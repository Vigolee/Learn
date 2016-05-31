package learn.java.concurrent.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 数据库连接池
 * Created by Vigo on 16/5/31.
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.add(DBConnection.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connect) {
        if (connect != null) {
            synchronized (pool) {
                pool.addLast(connect);
                //释放资源后通知其他线程
                pool.notifyAll();
            }
        }
    }

    public  Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            // 完全超时
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                /** 判断是是因为超时退出循环，或因为池子里有连接了*/
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }

}
