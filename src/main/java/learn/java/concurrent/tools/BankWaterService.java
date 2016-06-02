package learn.java.concurrent.tools;

import java.util.Map;
import java.util.concurrent.*;

/**
 * CyclicBarrier应用场景
 * Created by Vigo on 16/6/2.
 */
public class BankWaterService  implements Runnable{

    private static final int NUM = 4;

    /** !!!!!!!线程到底屏障时，优先执行本线程，自动调用run，不需要start!!!!!!*/
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM, this);

    private Executor executor = Executors.newFixedThreadPool(NUM);

    private ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<String, Integer>();

    public void count() {

        for (int i = 0; i < NUM; i++) {
            executor.execute(new Runnable() {
                public void run() {
                    // 计算当前sheet数据，代码省略
                    // 存入计算结果
                    countMap.put(Thread.currentThread().getName(), 1);

                    // 插入一个屏障
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : countMap.entrySet()) {
            result += sheet.getValue();
        }

        // 输出结果
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService service = new BankWaterService();
        service.count();
    }
}
