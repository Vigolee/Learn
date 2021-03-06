package learn.test;

/**
 * Created by Vigo on 17/12/28.
 */
/**
 * 自定义的一个UncaughtExceptionHandler
 */
class ErrHandler implements Thread.UncaughtExceptionHandler {
    /**
     * 这里可以做任何针对异常的处理,比如记录日志等等
     */
    public void uncaughtException(Thread a, Throwable e) {
        System.out.println("This is:" + a.getName() + ",Message:"
                + e.getMessage());
        e.printStackTrace();
    }
}