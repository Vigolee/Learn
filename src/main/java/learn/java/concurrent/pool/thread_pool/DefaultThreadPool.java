package learn.java.concurrent.pool.thread_pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 默认线程池实现
 * Created by Vigo on 16/5/31.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    /** 最大限制数*/
    private static final int MAX_WORKERS_NUM = 10;

    /** 最小数量*/
    private static final int MIN_WORKERS_NUM = 10;

    /** 默认数量*/
    private static final int DEFAULT_WORKERS_NUM = 10;

    /** 工作列表*/
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    /** 工作者列表*/
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());// 线程安全

    /** 工作者数量*/
    private int workNum;

    /** 生成线程编号*/
    private AtomicLong threadNum;

    public DefaultThreadPool() {
        initializeWorkers(DEFAULT_WORKERS_NUM);
    }

    /**
     * 执行任务
     * @param job
     */
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for (int i = 0; i < workers.size(); i++) {
            workers.get(i).shutdown();
        }
    }

    /**
     * 增加线程工作者
     * @param num
     */
    public void addWorkers(int num) {
        if (num + workNum > MAX_WORKERS_NUM) {
            num = MAX_WORKERS_NUM - workNum;
        }
        initializeWorkers(num);
        this.workNum += num;
    }

    /**
     * 移除num个线程工作者
     * @param num
     */
    public void removeWorkers(int num) {
        if (num > workNum){
            throw new IllegalArgumentException("beyond workNum");
        }

        if (workNum - num < MIN_WORKERS_NUM) {
            num = workNum - MIN_WORKERS_NUM;
        }

        for (int i = 0; i < num; i++) {
            Worker work = workers.get(i);
            if (workers.remove(work)) {
                work.shutdown();
            }
        }
        workNum -= num;
    }

    public int getJobSize() {
        return jobs.size();
    }

    /**
     * 新增线程工作者
     * @param num
     */
    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(new Worker(),"Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    public class Worker implements Runnable {
        /** 判断是否工作*/
        private volatile boolean running = true;

        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception ex) {
                        // Job执行中的Exception
                    }
                }
            }
        }

        public void shutdown(){
            running = false;
        }
    }
}
