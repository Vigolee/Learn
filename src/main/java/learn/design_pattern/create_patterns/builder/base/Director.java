package learn.design_pattern.create_patterns.builder.base;

/**
 * Created by Vigo on 16/6/16.
 */
public class Director {

    private ProductBuilder builder;

    public Director() {
        builder = new ProductBuilder();
    }

    public Product build() {
        builder.buildPartA();
        builder.buildPartB();
        return builder.getProduct();
    }
}
