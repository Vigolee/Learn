package learn.design_pattern.factory.simple_factory;

import learn.design_pattern.factory.common_class.ProductA;

/**
 * 程序执行主类
 * Created by Vigo on 16/6/12.
 */
public class MainClass {
    public static void main(String[] args) {
        ProductA productA = (ProductA) ProductFactory.createProductA();
        productA.doSomething();
    }
}
