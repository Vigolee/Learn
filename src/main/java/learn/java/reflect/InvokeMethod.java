package learn.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制调用方法（不带参数、带参数、不带返回值、带返回值）
 * Created by Vigo on 16/5/29.
 */
public class InvokeMethod {

    /**
     * 带参数和返回值
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b){
        return a + b;
    }

    /**
     * 无参数和返回值
     */
    public void print(){
        System.out.println("This is a demo to show you how to invoke methods by reflect");
    }

    public static void main(String[] args) {
        /** 第一步，获取Class对象 */
        // 方法一：Class.forName()方法获取
        // 方法二：类名.class
        Class<InvokeMethod> invokeMethodClass = InvokeMethod.class;

        /** 第二步，生成对象 */
        try {
            Object obj = invokeMethodClass.newInstance();
            /** 第三步，获得与被调用方法对应的Method对象 */
            Method param_method = invokeMethodClass.getMethod("add"
                    ,new Class<?>[]{int.class
                    , int.class});//第一个参数是方法名，第二个参数是这个方法所需要的参数的Class对象的数组
            Method no_param_method = invokeMethodClass.getMethod("print");
            /** 第四步，调用目标方法 */
            Object result = param_method.invoke(obj, new Object[]{1, 2});// 带参数和返回值
            System.out.println("result is " + result);

            no_param_method.invoke(obj);// 无返回值方法

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("step 3 error");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("step 4 error");
            e.printStackTrace();
        }


    }
}
