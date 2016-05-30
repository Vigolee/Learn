package learn.java.proxy;

/**
 * Created by Vigo on 16/4/6.
 */
public class HelloWorldImpl implements HelloWorld {

    public void sayHelloWorld() {
        System.out.println("HelloWorld!");
    }

    public int calculate(int a, int b) {
        return a + b;
    }
}
