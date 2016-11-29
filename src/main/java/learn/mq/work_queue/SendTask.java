package learn.mq.work_queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * Created by Vigo on 16/11/29.
 */
public class SendTask {

    public static void main(String[] args) {

        // 获取连接
        Connection connection = MQConnection.getMQLocalConnection();
        try {
            // 创建通道
            Channel channel = connection.createChannel();
            // 指定队列
            boolean durable = true; // 消息可持久化
            channel.queueDeclare(Configuration.WORK_QUEUE_NAME, durable, false, false, null);
            for (int i = 0; i < 10; i++) {
                String message = "hello_" + i;
                // 向队列中发送消息
                // 标识信息为持久化的
                channel.basicPublish("", Configuration.WORK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            }
            //关闭频道和资源
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
