package learn.rubic.rubic_core.excute.io_task;

import learn.rubic.rubic_core.data_factory.DataStructFactory;
import learn.rubic.rubic_core.excute.*;
import learn.rubic.rubic_core.excute.Process;
import learn.rubic.rubic_core.model.DataSetInfo;
import learn.rubic.rubic_framework.train_data.DataSet;
import learn.rubic.rubic_framework.train_data.DataStruct;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vigo on 16/8/30.
 */
public class DataLoader implements Runnable {

    private learn.rubic.rubic_core.excute.Process process;

    private DataSetInfo[] dataSetInfo;

    private CyclicBarrier cyclicBarrier;

    public DataLoader(Process process, DataSetInfo[] dataSetInfo, CyclicBarrier cyclicBarrier) {
        this.process = process;
        this.dataSetInfo = dataSetInfo;
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        DataSet dataSet = new DataSet();
        DataStructFactory factory = new DataStructFactory();
        for (int i = 0; i < dataSetInfo.length; i++) {
            DataStruct dataStruct = factory.getDataStruct(dataSetInfo[i]);
            dataSet.addDataStruct(dataStruct, dataSetInfo[i].getType());
        }
        process.setDataSet(dataSet);

        try {
            // 等待算法加载完成
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
