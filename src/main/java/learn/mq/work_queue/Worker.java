package learn.mq.work_queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/29.
 */
public class Worker {


    public static void handleMessage(String message){
        for (char ch : message.toCharArray())
        {
            if (ch == '1')
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            if (ch == '_')
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        try {
            // 获取连接
            Connection connection = MQConnection.getMQLocalConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 防止消息接收者先运行此程序，队列还不存在时创建队列
//            channel.queueDeclare(Configuration.WORK_QUEUE_NAME, false, false, false, null);
            System.out.println("[r*] waiting for message. To exit press CTRL + C");
            /**
             * 公平转发（Fair dispatch）
             * don't dispatch a new message to a worker
             * until it has processed and acknowledged the previous one
             */
            int prefetchCount = 1;
            channel.basicQos(prefetchCount);
            // 创建队列消费者
            QueueingConsumer consumer = new QueueingConsumer(channel);
            // 指定消费队列
            boolean ack = false ; //打开应答机制
            channel.basicConsume(Configuration.WORK_QUEUE_NAME, ack, consumer);

            boolean flag = true;
            while (flag){
                //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println("[r*] Received '" + message + "'");
                // 消息处理
                handleMessage(message);
                System.out.println("[r*] Done");

                // 发送应答()应答机制
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
            // 释放资源
            channel.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
