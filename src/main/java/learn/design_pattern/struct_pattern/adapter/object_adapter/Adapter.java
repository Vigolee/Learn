package learn.design_pattern.struct_pattern.adapter.object_adapter;

/**
 * 适配器(委托的方式)
 * Created by Vigo on 16/7/24.
 */
public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void handle() {

        //使用委托的方式完成特殊功能 ;
        adaptee.request();
    }
}
