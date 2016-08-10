package learn.design_pattern.struct_pattern.adapter.object_adapter;


/**
 * Created by Vigo on 16/8/1.
 */
public class Main {

    public static void main(String[] args) {
        Target target = new Adapter(new Adaptee());
        target.handle();
    }
}
