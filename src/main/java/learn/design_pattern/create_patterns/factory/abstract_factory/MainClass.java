package learn.design_pattern.create_patterns.factory.abstract_factory;

import learn.design_pattern.create_patterns.factory.common_class.type.ProductA_1;

/**
 * Created by Vigo on 16/6/12.
 */
public class MainClass {

    public static void main(String[] args) {
        ProductA_1 productA_1 = (ProductA_1) new Type1Factory().createProductA();
        productA_1.doSomething();
    }
}
