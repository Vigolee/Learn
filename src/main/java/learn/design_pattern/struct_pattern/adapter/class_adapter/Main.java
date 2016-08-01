package learn.design_pattern.struct_pattern.adapter.class_adapter;

/**
 * Created by Vigo on 16/8/1.
 */
public class Main {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.handle();
    }
}
