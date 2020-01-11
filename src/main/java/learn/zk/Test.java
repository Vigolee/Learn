package learn.zk;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Vigo on 17/12/6.
 */
public class Test {

    public void test(){
        ArrayList<String> a = new ArrayList<String>();
        synchronized (a){
        try {
            System.out.println("wait");
            a.wait();
            System.out.println("dd");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        ConnectZookeeper c = new ConnectZookeeper();
//        c.connect(Config.host);
//        c.connect(Config.host);
//        Thread.sleep(Long.MAX_VALUE);
        Test t = new Test();
        t.test();

    }
}
