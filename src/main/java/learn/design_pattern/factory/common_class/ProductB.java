package learn.design_pattern.factory.common_class;

import learn.design_pattern.factory.common_interface.Product;

/**
 * Created by Vigo on 16/6/12.
 */
public class ProductB implements Product {
    public void doSomething() {
        System.out.println("create productB");
    }
}
