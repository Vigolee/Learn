package learn.design_pattern.create_patterns.factory.abstract_factory;

import learn.design_pattern.create_patterns.factory.common_class.type.ProductA_2;
import learn.design_pattern.create_patterns.factory.common_class.type.ProductB_2;
import learn.design_pattern.create_patterns.factory.common_interface.AbstractFactory;
import learn.design_pattern.create_patterns.factory.common_interface.Product;

/**
 * 生产产品类型2的工厂类
 * Created by Vigo on 16/6/12.
 */
public class Type2Factory implements AbstractFactory {
    public Product createProductA() {
        return new ProductA_2();
    }

    public Product createProductB() {
        return new ProductB_2();
    }
}
