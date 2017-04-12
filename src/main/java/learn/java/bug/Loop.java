package learn.java.bug;

/**
 * Created by Vigo on 17/4/3.
 */
public class Loop {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while (true){
                    System.out.println("*");
                }
            }
        },"vigoTHread").start();

    }
}
