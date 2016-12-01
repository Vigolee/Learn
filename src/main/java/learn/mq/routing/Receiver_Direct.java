package learn.mq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/30.
 */
public class Receiver_Direct {

    private static final String[] SEVERITIES = { "info", "warning", "error" };

    /**
     * 随机产生一种日志类型
     * @return
     */
    public static String getServerity(){
        Random random = new Random();
        int ranVal = random.nextInt(3);
        return SEVERITIES[ranVal];
    }

    public static void main(String[] args) {
        try {
            // 获取连接
            Connection connection = MQConnection.getMQLocalConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 声明转发器和类型
            channel.exchangeDeclare(Configuration.EXCHANGE_NAME, "direct");
            // 创建一个非持久的、唯一的且自动删除的队列
            String queueName = channel.queueDeclare().getQueue();

            String severity = getServerity();
            // 为转发器指定队列，设置binding
            channel.queueBind(queueName, Configuration.EXCHANGE_NAME, severity);

            System.out.println("[r*] waiting for " + severity + " message. To exit press CTRL + C");

            // 创建队列消费者
            QueueingConsumer consumer = new QueueingConsumer(channel);
            // 指定接收者，第二个参数为自动应答，无需手动应答
            channel.basicConsume(queueName, true, consumer);
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
