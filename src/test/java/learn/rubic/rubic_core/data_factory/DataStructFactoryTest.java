package learn.rubic.rubic_core.data_factory;

import learn.rubic.rubic_core.model.DataSetInfo;
import learn.rubic.rubic_framework.train_data.DataStruct;
import learn.rubic.rubic_framework.train_data.MatrixStruct;
import learn.rubic.rubic_framework.train_data.TextStruct;
import learn.web.config.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by Vigo on 16/8/25.
 */
public class DataStructFactoryTest extends BasicTest {

    @Resource(name = "dataStructFactory")
    private DataStructFactory dataStructFactory;

    @Test
    public void getDataStructTest(){
        String data_path = "/Users/lwg/Vigo/DataSet/iris.data";
        ArrayList<String> attributes = new ArrayList<String>();
        attributes.add("a1");
        attributes.add("a2");
        attributes.add("a3");
        attributes.add("a4");
        String label_attribute = "color";
        int type = 1;
        DataSetInfo dataSetInfo = new DataSetInfo(data_path, attributes, label_attribute, type);
        DataStruct dataStruct = dataStructFactory.getDataStruct(dataSetInfo);
        System.out.println(((MatrixStruct)dataStruct).toString());
    }

    @Test
    public void getDataStructTest2() {
        String data_path = "/Users/lwg/Vigo/DataSet/text.txt";
        ArrayList<String> attributes = new ArrayList<String>();
        attributes.add("a1");
        String label_attribute = "catalog";
        int type = 2;
        DataSetInfo dataSetInfo = new DataSetInfo(data_path, attributes, label_attribute, type);
        DataStruct dataStruct = dataStructFactory.getDataStruct(dataSetInfo);
        System.out.println(((TextStruct) dataStruct).toString());
    }
}
