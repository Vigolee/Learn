package learn.design_pattern.behaviour_patterns.state;

/**
 * 抽象状态类
 * Created by Vigo on 17/4/19.
 */
public abstract class State {

    protected Context context;

    public State setContext(Context context) {
        this.context = context;
        return this;
    }

    public abstract void handle1();

    public abstract void handle2();
}
