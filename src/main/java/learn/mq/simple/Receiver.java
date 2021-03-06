package learn.mq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 等待服务器推送消息，消费
 * Created by Vigo on 16/11/29.
 */
public class Receiver {

    public static void main(String[] args) {
        try {
            // 获取连接
            Connection connection = MQConnection.getMQLocalConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 防止消息接收者先运行此程序，队列还不存在时创建队列
            channel.queueDeclare(Configuration.QUEUE_NAME, false, false, false, null);
            System.out.println("[r*] waiting for message. To exit press CTRL + C");

            // 创建队列消费者
            QueueingConsumer consumer = new QueueingConsumer(channel);
            // 指定消费队列
            channel.basicConsume(Configuration.QUEUE_NAME, true, consumer);
            boolean flag = true;
            while (flag){
                //nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody());
                System.out.println(" [r*] Received '" + message + "'");

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
