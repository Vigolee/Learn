package learn.java.generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ParameterizedType表示参数化类型，也就是泛型，例如List<T>、Set<T>等
 * 在ParameterizedType接口中，有3个方法，分别是:
 * getActualTypeArguments()、 getRawType()、 getOwnerType();
 * Created by Vigo on 17/11/21.
 */
public class ParameterizedTypeTest<T> {

    private List<T> list = null;
    private Set<T> set = null;
    private Map<String, Integer> map;
    private Map.Entry<String, Integer> entry; // 用于测试owner

    /**
     * 测试getActualTypeArguments方法（返回Type[],因为可能存在多个泛型类型）
     */
    public static void getActualTypeArgumentsTest() throws NoSuchFieldException {

        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("list");
        Type typeMap = fieldMap.getGenericType();

        System.out.println(typeMap.toString());//java.util.Map<java.lang.String, java.lang.Integer>

        // 获取泛型中实际类型
        ParameterizedType parameterizedTypeMap = (ParameterizedType) typeMap;
        Type[] types = parameterizedTypeMap.getActualTypeArguments();
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
        }
        // class java.lang.String
        // class java.lang.Integer
    }

    /**
     * 测试getRawType，获取声明泛型的类或者接口，也就是泛型中<>前面的那个值
     */

    public static void getRawTypeTest() throws NoSuchFieldException {

        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("map");
        Type typeMap = fieldMap.getGenericType();

        System.out.println(typeMap.toString());//java.util.Map<java.lang.String, java.lang.Integer>

        // 获取泛型中实际类型
        ParameterizedType parameterizedTypeMap = (ParameterizedType) typeMap;

        Type type = parameterizedTypeMap.getRawType();//interface java.util.Map
        System.out.println(type);

    }

    /**
     * 获取泛型的拥有者,“拥有者”表示的含义--内部类的“父类”，
     * 通过getOwnerType()方法可以获取到内部类的“拥有者”；
     * 例如： Map  就是 Map.Entry<String,String>的拥有者；
     */
    public static void getOwnerTypeTest() throws NoSuchFieldException {
        Field fieldMapEntry = ParameterizedTypeTest.class.getDeclaredField("entry");
        Type typeMapEntry = fieldMapEntry.getGenericType();

        ParameterizedType parameterizedTypeMap = (ParameterizedType) typeMapEntry;

        Type type = parameterizedTypeMap.getOwnerType();

        System.out.println(type);
    }



    public static void main(String[] args) throws NoSuchFieldException {
        Field fieldList = ParameterizedTypeTest.class.getDeclaredField("list");
        // 获取泛型类型
        Type typeList = fieldList.getGenericType();
        // 获取实际Type类型
        System.out.println(typeList.toString());//java.util.List<T>
        System.out.println(typeList.getClass().getName());//sun.reflect.generics.reflectiveObjects.ParameterizedTypeImplSystem.out.println("getRawTypeTest");

        System.out.println("-------getActualTypeArgumentsTest------");
        getActualTypeArgumentsTest();
        System.out.println("-------getRawTypeTest-----------");
        getRawTypeTest();
        System.out.println("-------getOwnerTypeTest-----------");
        getOwnerTypeTest();

    }
}
