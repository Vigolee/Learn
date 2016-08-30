package learn.rubic.rubic_core.data_factory;

import learn.rubic.rubic_core.file_handle.FileReader;
import learn.rubic.rubic_core.model.DataSetInfo;
import learn.rubic.rubic_framework.train_data.DataStruct;
import learn.rubic.rubic_framework.train_data.MatrixStruct;
import learn.rubic.rubic_framework.train_data.TextStruct;
import org.springframework.stereotype.Service;

/**
 * 数据构造工厂
 * Created by Vigo on 16/8/25.
 */
@Service("dataStructFactory")
public class DataStructFactory {

    public DataStruct getDataStruct(DataSetInfo dataSetInfo) {
        switch (dataSetInfo.getType()){
            case 1 : return createMatrixStruct(dataSetInfo);
            case 2 : return createTextStruct(dataSetInfo);
            default:
                System.out.println("Data type " + dataSetInfo.getType() + " is not exit");
                return null;
        }
    }

    /**
     * 矩阵型数据
     * @param dataSetInfo
     * @return
     */
    private MatrixStruct createMatrixStruct(DataSetInfo dataSetInfo) {
        MatrixStruct matrixStruct = new MatrixStruct();
        matrixStruct.setAttributes(dataSetInfo.getAttributes());
        matrixStruct.setLabel_attribute(dataSetInfo.getLabel_attribute());
        matrixStruct.setMatrixExamples(FileReader.readMatrixData(dataSetInfo.getData_path(),
                dataSetInfo.isHasLabel()));
        return matrixStruct;
    }

    /**
     * 文本型数据
     * @param dataSetInfo
     * @return
     */
    private TextStruct createTextStruct(DataSetInfo dataSetInfo){
        TextStruct textStruct = new TextStruct();
        textStruct.setAttribute(dataSetInfo.getAttributes().get(0));
        textStruct.setLabel_attribute(dataSetInfo.getLabel_attribute());
        textStruct.setTextExamples(FileReader.readTextData(dataSetInfo.getData_path(),
                dataSetInfo.isHasLabel()));
        return textStruct;
    }
}
