package learn.rubic.rubic_framework.excute_interface;

import learn.rubic.rubic_framework.result_data.ResultDataSet;
import learn.rubic.rubic_framework.train_data.DataSet;

/**
 * 算法实现的运行接口
 * Created by Vigo on 16/8/26.
 */
public interface OperationalData {

    public ResultDataSet run(DataSet input, Object configuration,
                          double... parameters);

    public Object trainingModel(DataSet input, Object object);

    public ResultDataSet usingModel(DataSet input, Object object);

}
