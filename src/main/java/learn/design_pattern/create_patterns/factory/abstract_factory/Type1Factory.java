package learn.design_pattern.create_patterns.factory.abstract_factory;

import learn.design_pattern.create_patterns.factory.common_class.type.ProductA_1;
import learn.design_pattern.create_patterns.factory.common_class.type.ProductB_1;
import learn.design_pattern.create_patterns.factory.common_interface.AbstractFactory;
import learn.design_pattern.create_patterns.factory.common_interface.Product;

/**
 * 生产产品类型1的工厂类
 * Created by Vigo on 16/6/12.
 */
public class Type1Factory implements AbstractFactory {
    public Product createProductA() {
        return new ProductA_1();
    }

    public Product createProductB() {
        return new ProductB_1();
    }
}
