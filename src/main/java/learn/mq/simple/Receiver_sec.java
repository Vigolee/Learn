package learn.mq.simple;

import com.rabbitmq.client.*;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 回调方式获取消息
 * Created by Vigo on 16/11/29.
 */
public class Receiver_sec {

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
            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("[r*] Received '" + message + "'");
                }
            };
            channel.close();
            connection.close();
            channel.basicConsume(Configuration.QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
