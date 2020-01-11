package learn.java.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by Vigo on 2019/5/20.
 */
public class IntrospectorDemo {

    static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public User setAge(int age) {
            this.age = age;
            return this;
        }
    }

    public static void demo1() throws Exception {
        User u = new User("vigo", 21);
        String propertyName ="name";
        // 指定要访问的属性
        PropertyDescriptor pd = new PropertyDescriptor(propertyName, u.getClass());
        // 获取读方法
        Method readMethod = pd.getReadMethod();
        // 反射机制调用
        Object value = readMethod.invoke(u, null);
        System.out.println("name=" + value);
        pd.getWriteMethod().invoke(u, "lee");
        value = readMethod.invoke(u, null);
        System.out.println("newName=" + value);
    }

    public static void demo2() throws Exception{
        User user = new User("vigo", 21);
        // 获取整个bean信息
//        BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass());
        // 在Object类时停止检索，可以选择任意父类停止
        BeanInfo beanInfo = Introspector.getBeanInfo(user.getClass());
        System.out.println("所有属性描述：");
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor:pds){
            System.out.println(propertyDescriptor.getName());
        }
        System.out.println("所有方法描述：");
        for (MethodDescriptor md:beanInfo.getMethodDescriptors()){
            Method method = md.getMethod();
        }
    }
}  