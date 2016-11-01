package learn.rubic.rubic_core.file_handle;

import learn.rubic.rubic_framework.train_data.MatrixExample;
import learn.rubic.rubic_framework.train_data.TextExample;
import org.junit.Test;

/**
 * Created by Vigo on 16/8/25.
 */
public class ExampleToolsTest {

    @Test
    public void generateMatrixExampleTest1(){
        String line = "5.1,3.5,1.4,0.2,Iris-setosa";
        boolean hasLabel = true;
        MatrixExample matrixExample = ExampleTools.generateMatrixExample(line, hasLabel);
        System.out.println(matrixExample.toString());
    }

    @Test
    public void generateMatrixExampleTest2(){
        String line = "5.1,3.5,1.4,0.2";
        boolean hasLabel = false;
        MatrixExample matrixExample = ExampleTools.generateMatrixExample(line, hasLabel);
        System.out.println(matrixExample.toString());
    }

    @Test
    public void generateTextExampleTest1(){
        String line = "hello, I am Vigo**female";
        boolean hasLabel = true;
        TextExample textExample = ExampleTools.generateTextExample(line, hasLabel);
        System.out.println(textExample.toString());
    }

    @Test
    public void generateTextExampleTest2(){
        String line = "hello, I am Vigo";
        boolean hasLabel = false;
        TextExample textExample = ExampleTools.generateTextExample(line, hasLabel);
        System.out.println(textExample.toString());
    }
}
