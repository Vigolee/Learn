package learn.java.concurrent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created by Vigo on 2019/5/21.
 */
public class ShutdownHookDemo {

    public static void main(String[] args) {
        // spring启动时会触发各service启动
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ShutdownHookDemo.class);
        if (context instanceof AbstractApplicationContext){
            // 关闭钩子
            ((AbstractApplicationContext) context).registerShutdownHook();
        }

    }
}  