package learn.mq.conf;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        factory.setUsername("guest");
        factory.setPassword("guest");
//        factory.setVirtualHost("/vhost_1");
        Connection connection = null;
        try {
            connection = factory.newConnection();
            HashMap<String, Object> maps = (HashMap<String, Object>) connection.getClientProperties();
            Iterator it = maps.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        MQConnection.getMQLocalConnection();
    }
}
