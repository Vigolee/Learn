package learn.design_pattern.factory.factory_method;

import learn.design_pattern.factory.common_class.ProductB;
import learn.design_pattern.factory.common_interface.Factory;
import learn.design_pattern.factory.common_interface.Product;

/**
 * Created by Vigo on 16/6/12.
 */
public class ProductBFactory implements Factory {
    public Product createProduct() {
        return new ProductB();
    }
}
