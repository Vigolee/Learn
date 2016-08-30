package learn.rubic.rubic_core.excute;

import learn.rubic.rubic_core.excute.io_task.AlgorithmLoader;
import learn.rubic.rubic_core.excute.io_task.DataLoader;
import learn.rubic.rubic_core.model.AlgorithmInfo;
import learn.rubic.rubic_core.model.DataSetInfo;
import learn.rubic.rubic_framework.excute_interface.OperationalData;
import learn.rubic.rubic_framework.result_data.ResultDataSet;
import learn.rubic.rubic_framework.train_data.DataSet;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 一次运算
 * Created by Vigo on 16/8/30.
 */
public class Process {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    private Executor executor = Executors.newFixedThreadPool(100);

    private DataSet input;

    private OperationalData operationalData;

    /**
     * 数据加载 (I/O 线程池中执行)
     * @param dataSetInfo
     * @return
     */
    public void loadData(DataSetInfo[] dataSetInfo){
        executor.execute(new DataLoader(this, dataSetInfo, cyclicBarrier));
    }

    /**
     * 算法加载 (I/O 线程池中执行)
     * @param algorithmInfo
     * @return
     */
    private void loadAlgorithm(AlgorithmInfo algorithmInfo){
        executor.execute(new AlgorithmLoader(this, algorithmInfo, cyclicBarrier));
    }

    /**
     * 生成模型 (Worker 线程池中执行)
     * @param dataSetInfo
     * @param algorithmInfo
     * @return
     */
    public ResultDataSet run(DataSetInfo[] dataSetInfo, AlgorithmInfo algorithmInfo){
        loadData(dataSetInfo);
        loadAlgorithm(algorithmInfo);
        return operationalData.run(input, null, null);
    }

    /**
     * 使用模型 (Worker 线程池中执行)
     * @param dataSetInfo
     * @param algorithmInfo
     * @param model
     * @return
     */
    public ResultDataSet usingModel(DataSetInfo[] dataSetInfo, AlgorithmInfo algorithmInfo,
                                    Object model){
        loadData(dataSetInfo);
        loadAlgorithm(algorithmInfo);
        return operationalData.usingModel(input, model);
    }

    public void setDataSet(DataSet dataSet){
        this.input = dataSet;
    }

    public Process setOperationalData(OperationalData operationalData) {
        this.operationalData = operationalData;
        return this;
    }
}
