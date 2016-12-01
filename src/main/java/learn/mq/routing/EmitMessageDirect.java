package learn.mq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import learn.mq.conf.Configuration;
import learn.mq.conf.MQConnection;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/30.
 */
public class EmitMessageDirect {

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
            // 声明转发器为direct
            channel.exchangeDeclare(Configuration.EXCHANGE_NAME, "direct");

            String message = new Date().getTime()+" : log something";


            // 往转发器上发送消息
            channel.basicPublish(Configuration.EXCHANGE_NAME,  getServerity(), null, message.getBytes());

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
