package learn.design_pattern.builder.multi_params;

/**
 * Created by Vigo on 16/6/16.
 */
public class MainClass {

    public static void main(String[] args) {
        Product product = new Product.ProductBuilder("BMW", "car").setColor("black")
                .setPrice("1000000000").setShape("circle").build();
        System.out.println(product);
    }
}
