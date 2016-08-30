package learn.rubic.rubic_core.excute;

import learn.rubic.rubic_core.model.AlgorithmInfo;
import learn.rubic.rubic_core.model.DataSetInfo;
import learn.rubic.rubic_framework.excute_interface.OperationalData;
import learn.rubic.rubic_framework.result_data.ResultDataSet;
import learn.rubic.rubic_framework.train_data.DataSet;

/**
 * 一次运算
 * Created by Vigo on 16/8/30.
 */
public class Process {

    /**
     * 数据加载 (I/O 线程池中执行)
     * @param dataSetInfo
     * @return
     */
    private DataSet loadData(DataSetInfo[] dataSetInfo){
        return null;
    }

    /**
     * 算法加载 (I/O 线程池中执行)
     * @param algorithmInfo
     * @return
     */
    private OperationalData loadAlgorithm(AlgorithmInfo algorithmInfo){
        return null;
    }

    /**
     * 生成模型 (Worker 线程池中执行)
     * @param dataSetInfo
     * @param algorithmInfo
     * @return
     */
    public ResultDataSet run(DataSetInfo[] dataSetInfo, AlgorithmInfo algorithmInfo){
        DataSet input = loadData(dataSetInfo);
        OperationalData operationalData = loadAlgorithm(algorithmInfo);
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
        DataSet input = loadData(dataSetInfo);
        OperationalData operationalData = loadAlgorithm(algorithmInfo);
        return operationalData.usingModel(input, model);
    }

}
