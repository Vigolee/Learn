package learn.design_pattern.create_patterns.single;

/**
 * 双重锁保证线程安全
 * Created by Vigo on 17/8/21.
 */
public class SingleA {
    private static volatile SingleA instance;

    private SingleA() {
    }

    public SingleA getInstance(){
        if (instance == null){
            synchronized (SingleA.class){
                if(instance == null){
                    instance = new SingleA();
                }
            }
        }
        return instance;
    }
}
