package learn.java.concurrent.tools;

import java.util.concurrent.*;

/**
 * Created by Vigo on 16/6/2.
 */
public class ExchangerTest {
    private static final Exchanger<String> exchange = new Exchanger<String>();

    private static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        pool.execute(new Runnable() {
            public void run() {
                String A = "this is A";
                try {
                    String s = exchange.exchange(A);
                    System.out.println("s: " + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.execute(new Runnable() {
            public void run() {
                String B = "This is B";
                try {
                    String A = exchange.exchange("abc");

                    if (A.equals(B)) {
                        System.out.println("A is B");
                    } else {
                        System.out.println("A not B");
                        System.out.println(A);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pool.shutdown();
    }

}
