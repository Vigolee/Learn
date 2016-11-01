package learn.rubic.rubic_core.file_handle;

import learn.rubic.rubic_framework.train_data.MatrixExample;
import learn.rubic.rubic_framework.train_data.TextExample;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Vigo on 16/8/25.
 */
public class FileReaderTest {

    @Test
    public void readMatrixDataTest(){
        String data_path = "/Users/lwg/Vigo/DataSet/iris.data";
        boolean hasLabel = true;
        ArrayList<MatrixExample> matrixExamples = FileReader.readMatrixData(data_path, hasLabel);
        System.out.println(matrixExamples.toString());
    }

    @Test
    public void readTextDataTest(){
        String data_path = "/Users/lwg/Vigo/DataSet/text.txt";
        boolean hasLabel = true;
        ArrayList<TextExample> textExamples = FileReader.readTextData(data_path, hasLabel);
        System.out.println(textExamples.toString());
    }
}
