package learn.java.concurrent.pool.thread_pool;

/**
 * 线程池接口
 * Created by Vigo on 16/5/31.
 */
public interface ThreadPool <Job extends Runnable> {

    /** 执行一个job */
    void execute(Job job);

    /** 关闭线程池 */
    void shutdown();

    /** 增加工作线程 */
    void addWorkers(int num);

    /** 减少工作线程*/
    void removeWorkers(int num);

    /** 获取正在执行的任务数量 */
    int getJobSize();
}
