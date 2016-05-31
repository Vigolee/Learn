package learn.java.concurrent.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试数据库连接池工作情况
 * Created by Vigo on 16/5/31.
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);

    /** 保证所有线程同时开始获取连接*/
    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end;

    private int a;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 1000;// 定义线程数量
        end = new CountDownLatch(threadCount);

        int count = 20;// 定义每个线程获取连接次数
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notgot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            new Thread(new ClientRunner(count, got, notgot)).start();
        }
        /** 所有线程同时开始获取连接*/
        start.countDown();
        /** 等待所有线程执行完毕*/
        end.await();

        /** 统计*/
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notgot);



    }

    static class ClientRunner implements Runnable {
        /** 总的获取次数*/
        int count;

        /** 获取到连接次数*/
        AtomicInteger got;

        /** 未获取到连接次数*/
        AtomicInteger notgot;

        public ClientRunner(int count, AtomicInteger got, AtomicInteger notgot) {
            this.count = count;
            this.got = got;
            this.notgot = notgot;
        }

        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count > 0) {
                try {
                    /** 获取连接*/
                    Connection connect = pool.fetchConnection(100);
                    if (connect != null) {// 成功
                        try {
                            connect.createStatement();
                            //connect.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connect);
                            got.incrementAndGet();
                        }
                    } else { // 获取失败
                        notgot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
