package learn.mq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/29.
 */
public class Sender {

    public static void main(String[] args) {

        try {
            // 获取连接
            Connection connection = MQConnection.getMQLocalConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 指定队列
            channel.queueDeclare(Configuration.QUEUE_NAME, false, false, false, null);
            String message = "hello word";
            // 向队列中发送消息
            channel.basicPublish("", Configuration.QUEUE_NAME, null, message.getBytes());
            System.out.println("[v] sent " + message );

            // 释放资源
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


}
