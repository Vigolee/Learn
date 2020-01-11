package learn.java.concurrent.lock.cross;

/**
 * 交叉打印A和B
 * Created by Vigo on 17/8/19.
 */
public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread A = new Thread(new ThreadA(printer));
        Thread B = new Thread(new ThreadB(printer));
        A.start();
        B.start();
    }
}
