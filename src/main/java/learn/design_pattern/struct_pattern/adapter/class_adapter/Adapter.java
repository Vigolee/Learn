package learn.design_pattern.struct_pattern.adapter.class_adapter;

/**
 * 适配器
 * Created by Vigo on 16/7/24.
 */
public class Adapter extends Adaptee implements Target{

    public void handle() {
        super.request();
    }
}
