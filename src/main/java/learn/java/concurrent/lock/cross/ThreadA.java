package learn.java.concurrent.lock.cross;

/**
 * Created by Vigo on 17/8/19.
 */
public class ThreadA implements Runnable {

    private Printer printer;

    public ThreadA(Printer printer) {
        this.printer = printer;
    }



    public void run() {
        for (int i = 0; i < 10; i++) {
            printer.printA();
        }
    }


}
