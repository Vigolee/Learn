package learn.java.concurrent.lock.cross;

/**
 * 打印机：类似于生产者消费者队列，元素为1
 * Created by Vigo on 17/8/19.
 */
public class Printer {

    private boolean flag = false;

    public synchronized void printA(){
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag = true;
        this.notify();
    }

    public synchronized void printB(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag = false;
        this.notify();
    }
}
