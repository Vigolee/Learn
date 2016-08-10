package learn.design_pattern.create_patterns.builder.base;

/**
 * 产品建造类
 * Created by Vigo on 16/6/16.
 */
public class ProductBuilder implements Builder {

    private Product product = new Product();

    public void buildPartA() {
        product.setName("product");
    }

    public void buildPartB() {
        product.setType("A");
    }

    public Product getProduct() {
        return product;
    }
}
