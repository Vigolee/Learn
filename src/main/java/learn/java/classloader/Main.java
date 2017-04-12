package learn.java.classloader;

/**
 * 测试自定义类加载器
 * Created by Vigo on 16/5/29.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {

        int i = 0 ;
        VigoClassLoader vigoClassLoader = new VigoClassLoader() ;

        while(true){
            // 同一个ClassLoader不能多次加载同一个类
//            VigoClassLoader vigoClassLoader = new VigoClassLoader() ;
            //不使用loadClass方法由于双亲委派模式，会将learn.java.reflect.Person交给vigoClassLoader的父ClassLoader进行加载。
            // 而其父ClassLoader对加载的Class做了缓存，如果发现该类已经加载过， 就不会再加载第二次。
            Class<?> personClass =  vigoClassLoader.findClass("learn.java.classloader.Person");

            try {
                Object person =  personClass.newInstance() ;
                Method sayHelloMethod = personClass.getMethod("sayHello") ;
                sayHelloMethod.invoke(person) ;
                System.out.println(++i);
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}