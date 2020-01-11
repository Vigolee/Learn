package learn.java.concurrent.interrupt;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Vigo on 2020/1/11.
 */
public class InterruptDemo {

    static class SleepThread implements Runnable {

        public void run() {
            while (true){
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 设置中断
                    Thread.currentThread().interrupted();
                }
                System.out.println("do...continue");
            }
        }
    }

    static class ParkThread implements Runnable {

        public void run() {
            int count = 100;
            while (count > 0){
                LockSupport.park();
                System.out.println("do continue");
                count--;
                // 线程中断后继续执行
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }

    public static void main(String[] args) {
        Thread sleep = new Thread(new SleepThread());
        sleep.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

        }
        sleep.interrupt();
        System.out.println("sleep's interrupted is " + sleep.isInterrupted());
    }
}  