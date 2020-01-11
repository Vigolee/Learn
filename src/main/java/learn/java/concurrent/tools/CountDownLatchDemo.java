package learn.java.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 并发工具类
 * Created by Vigo on 16/5/31.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new ThreadDemo(countDownLatch)).start();
//        countDownLatch.await(1000, TimeUnit.MILLISECONDS);// 主线程等待
        countDownLatch.await();
        System.out.println(3);
    }

    static class ThreadDemo implements Runnable {

        private CountDownLatch countDownLatch;

        public ThreadDemo(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            System.out.println(1);
            countDownLatch.countDown();
            System.out.println(2);
            countDownLatch.countDown();
        }
    }
}
