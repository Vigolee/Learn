package learn.design_pattern.create_patterns.factory.simple_factory;

import learn.design_pattern.create_patterns.factory.common_class.ProductA;
import learn.design_pattern.create_patterns.factory.common_class.ProductB;
import learn.design_pattern.create_patterns.factory.common_interface.Product;

/**
 * 简单工厂类
 * Created by Vigo on 16/6/12.
 */
public class ProductFactory {

    public static Product createProductA() {
        return new ProductA();
    }

    public static Product createProductB() {
        return new ProductB();
    }
}
