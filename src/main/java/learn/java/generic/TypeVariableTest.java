package learn.java.generic;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * 泛型的类型变量，指的是List<T>、Map<K,V>中的T，K，V等值，实际的Java类型是TypeVariableImpl
 * Created by Vigo on 17/11/24.
 */
public class TypeVariableTest< T extends Number & Comparable & Serializable> {

    private T t;


    public static TypeVariable getTypeVariable(String var) throws NoSuchFieldException {
        Field field = TypeVariableTest.class.getDeclaredField(var);
        Type fieldType = field.getGenericType();
        // 获取泛型中实际类型
        TypeVariable typeVariable = (TypeVariable) fieldType;
        return typeVariable;
    }

    /**
     * 测试：GetBounds方法
     * 获得该类型变量的上限，也就是泛型中extend右边的值；例如 List<T extends Number> ，
     * Number就是类型变量T的上限；
     * 如果我们只是简单的声明了List<T>（无显式定义extends），那么默认为Object；
     */
    public static void testGetBounds(String var) throws NoSuchFieldException {
        TypeVariable type = getTypeVariable(var);
        Type[] types = type.getBounds();
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
        }
    }

    /**
     * 测试：GetGenericDeclaration方法
     * 获取声明该类型变量实体，也就是TypeVariableTest<T>中的TypeVariableTest
     * @param var
     * @throws NoSuchFieldException
     */
    public static void testGetGenericDeclaration(String var) throws NoSuchFieldException {
        TypeVariable type = getTypeVariable(var);
        GenericDeclaration genericDeclaration = type.getGenericDeclaration();
        System.out.println(genericDeclaration);
    }

    /**
     * 测试:GetName
     * 获取类型变量在源码中定义的名称
     * @param var
     * @throws NoSuchFieldException
     */
    public static void testGetName(String var) throws NoSuchFieldException {
        TypeVariable type = getTypeVariable(var);
        String name = type.getName();
        System.out.println(name);
    }



    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println("-------testGetBounds------");
        testGetBounds("t");
        System.out.println("-------testGetGenericDeclaration------");
        testGetGenericDeclaration("t");
        System.out.println("-------testGetName------");
        testGetName("t");
    }
}
