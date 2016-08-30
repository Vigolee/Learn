package learn.rubic.rubic_core.excute.io_task;

import learn.rubic.rubic_core.excute.Process;
import learn.rubic.rubic_core.model.AlgorithmInfo;
import learn.rubic.rubic_framework.excute_interface.OperationalData;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vigo on 16/8/30.
 */
public class AlgorithmLoader implements Runnable {

    private learn.rubic.rubic_core.excute.Process process;

    private AlgorithmInfo algorithmInfo;

    private CyclicBarrier cyclicBarrier;

    public AlgorithmLoader(Process process, AlgorithmInfo algorithmInfo,
                         CyclicBarrier cyclicBarrier) {
        this.process = process;
        this.algorithmInfo = algorithmInfo;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        //加载算法
        OperationalData operationalData = null;

        process.setOperationalData(operationalData);
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
