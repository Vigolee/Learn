package learn.design_pattern.builder.base;

/**
 * Created by Vigo on 16/6/16.
 */
public class MainClass {

    public static void main(String[] args) {
        Product product = new Director().build();
        System.out.println(product);
    }
}
