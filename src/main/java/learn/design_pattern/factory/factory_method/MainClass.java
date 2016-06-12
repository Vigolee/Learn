package learn.design_pattern.factory.factory_method;

import learn.design_pattern.factory.common_class.ProductA;

/**
 * Created by Vigo on 16/6/12.
 */
public class MainClass {

    public static void main(String[] args) {
        ProductAFactory factoryA = new ProductAFactory();
        ProductA productA = (ProductA) factoryA.createProduct();
        productA.doSomething();
    }
}
