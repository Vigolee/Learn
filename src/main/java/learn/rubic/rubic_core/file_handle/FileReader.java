package learn.rubic.rubic_core.file_handle;

import learn.rubic.rubic_framework.train_data.MatrixExample;
import learn.rubic.rubic_framework.train_data.TextExample;

import java.io.*;
import java.util.ArrayList;

/**
 * 文件读写类 (与FileSystem相互)
 * Created by Vigo on 16/8/25.
 */
public class FileReader {

    /**
     * 读取矩阵型文件
     * @param data_path
     * @param hasLabel
     * @return
     */
    public static ArrayList<MatrixExample> readMatrixData(String data_path, boolean hasLabel) {

        ArrayList<MatrixExample> matrixExamples = new ArrayList<MatrixExample>();
        MatrixExample matrixExample;
        File file = new File(data_path);
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    file)));
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                matrixExample = ExampleTools.generateMatrixExample(line, hasLabel);
                matrixExamples.add(matrixExample);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrixExamples;
    }

    /**
     * 读取文本型文件
     * @param data_path
     * @param hasLabel
     * @return
     */
    public static ArrayList<TextExample> readTextData(String data_path, boolean hasLabel){
        ArrayList<TextExample> textExamples = new ArrayList<TextExample>();
        TextExample textExample;
        File file = new File(data_path);
        String line;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(
                    file)));
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                textExample = ExampleTools.generateTextExample(line, hasLabel);
                textExamples.add(textExample);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textExamples;
    }
}
