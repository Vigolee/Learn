package learn.mq.Publish_Subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/29.
 */
public class EmitMessage {

    public static void main(String[] args) {

        try {
            // 获取连接
            Connection connection = MQConnection.getMQLocalConnection();
            // 创建通道
            Channel channel = connection.createChannel();
            // 声明转发器和类型
            channel.exchangeDeclare(Configuration.EXCHANGE_NAME, "fanout");

            String message = new Date().getTime()+" : log something";

            // 往转发器上发送消息
            channel.basicPublish(Configuration.EXCHANGE_NAME, "", null, message.getBytes());

            System.out.println(" [x] Sent '" + message + "'");

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
