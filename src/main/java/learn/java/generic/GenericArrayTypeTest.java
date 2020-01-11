package learn.java.generic;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 泛型数组类型，例如List<String>[] 、T[]等；
 * Created by Vigo on 17/11/24.
 */
public class GenericArrayTypeTest {

    private List<String>[] listArray;

    /**
     * 公共方法
     * @param var 变量名
     * @return
     * @throws NoSuchFieldException
     */
    public static GenericArrayType getGenericArrayType(String var) throws NoSuchFieldException {

        Field field = GenericArrayTypeTest.class.getDeclaredField(var);
        Type fieldType = field.getGenericType();

//        System.out.println(fieldType.toString());

        // 获取泛型中实际类型
        GenericArrayType genericArrayType = (GenericArrayType) fieldType;
        return genericArrayType;
    }

    /**
     * getGenericComponentType返回泛型数组中元素的Type类型，
     * 即List<String>[] 中的 List<String>（ParameterizedTypeImpl）、
     * T[] 中的T（TypeVariableImpl）；
     * 值得注意的是，无论是几维数组，getGenericComponentType()方法都只会脱去最右边的[]，返回剩下的值
     * @param var
     * @throws NoSuchFieldException
     */
    public static void TestGetGenericComponentType(String var) throws NoSuchFieldException {
        GenericArrayType genericArrayType = getGenericArrayType(var);
        Type type = genericArrayType.getGenericComponentType();
        System.out.println(type.toString());

    }

    public static void main(String[] args) throws NoSuchFieldException {
        TestGetGenericComponentType("listArray");
    }
}
