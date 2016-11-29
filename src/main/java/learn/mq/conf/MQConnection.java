package learn.mq.conf;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Vigo on 16/11/29.
 */
public class MQConnection {

    /**
     * 获取MQ本地连接
     * @return
     */
    public static Connection getMQLocalConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Configuration.LOCAL_HOST);
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
