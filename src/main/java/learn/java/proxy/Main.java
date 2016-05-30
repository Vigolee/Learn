package learn.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Vigo on 16/4/6.
 */
public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorldImpl();
        InvocationHandler handler=new HelloWorldProxyHandler(helloWorld);
        HelloWorld proxy=(HelloWorld) Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                handler);
        proxy.sayHelloWorld();
        int sum = proxy.calculate(1, 2);
        System.out.println("sum: " + sum);

    }
}
