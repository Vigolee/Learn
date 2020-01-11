package learn.design_pattern.create_patterns.single;

/**
 * 静态内部类保证线程安全
 * Created by Vigo on 17/8/21.
 */
public class SingleB {


    private SingleB() {
    }

    public SingleB getInstance(){
        return InnerClass.instance;
    }

    static class InnerClass{
        private static SingleB instance = new SingleB();
    }
}
