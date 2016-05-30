package learn.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 * Created by Vigo on 16/4/6.
 */
public class HelloWorldProxyHandler implements InvocationHandler {
    private Object obj;

    public HelloWorldProxyHandler(Object obj) {
        super();
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy: " + proxy.getClass().getName());
        System.out.println("method: "  + method.getName());
        System.out.println("obj: " + obj.getClass().getName());
        doBefore();
        Object result=method.invoke(obj, args);
        doAfter();
        return result;

    }

    private void doBefore(){
        System.out.println("before method invoke");
    }

    private void doAfter(){
        System.out.println("after method invoke");
    }
}
