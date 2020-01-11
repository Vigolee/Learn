package learn.test;

/**
 * Created by Vigo on 17/12/28.
 */
class ThreadA extends Thread {

    public ThreadA() {

    }

    public void run() {

        double i = 12 / 0;// 抛出异常的地方
    }

}