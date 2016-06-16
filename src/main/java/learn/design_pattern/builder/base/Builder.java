package learn.design_pattern.builder.base;

/**
 * Created by Vigo on 16/6/16.
 */
public interface Builder {

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract Product getProduct();
}
