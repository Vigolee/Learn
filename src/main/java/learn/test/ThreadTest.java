package learn.test;


/**
 * Created by Vigo on 17/12/28.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ErrHandler handle = null;
        Thread a =  new ThreadA();
        handle = new ErrHandler();
        a.setUncaughtExceptionHandler(handle);// 加入定义的ErrHandler
        a.start();

    }

}