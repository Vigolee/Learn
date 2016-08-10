package learn.design_pattern.create_patterns.factory.factory_method;

import learn.design_pattern.create_patterns.factory.common_class.ProductA;
import learn.design_pattern.create_patterns.factory.common_interface.Factory;
import learn.design_pattern.create_patterns.factory.common_interface.Product;

/**
 * Created by Vigo on 16/6/12.
 */
public class ProductAFactory implements Factory {

    public Product createProduct() {
        return new ProductA();
    }
}
