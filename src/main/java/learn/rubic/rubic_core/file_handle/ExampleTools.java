package learn.rubic.rubic_core.file_handle;

import learn.rubic.rubic_framework.train_data.MatrixExample;
import learn.rubic.rubic_framework.train_data.TextExample;

/**
 * 构造一行数据工具类
 * Created by Vigo on 16/8/25.
 */
public class ExampleTools {

    /**
     * 解析一行矩阵型数据,转换为系统指定格式
     * @param line
     * @param hasLabel
     * @return
     */
    public static MatrixExample generateMatrixExample(String line, boolean hasLabel){
        MatrixExample matrixExample = new MatrixExample();

        line.replace("^\\s+|\\s+$", "");
        String[] tokens = line.split(",");
        if(!hasLabel){ //没有标签
            for (int i = 0; i < tokens.length; i++)
                matrixExample.add(tokens[i]);
        }else{
            for (int i = 0; i < tokens.length - 1; i++) {
                matrixExample.add(tokens[i]);
            }
            matrixExample.setLabel(tokens[tokens.length - 1]);
        }
        return matrixExample;
    }

    /**
     * 解析一行文本型数据,转换为系统指定格式
     * @param line
     * @param hasLabel
     * @return
     */
    public static TextExample generateTextExample(String line, boolean hasLabel){
        line.replace("^\\s+|\\s+$", "");
        String[] tokens = line.split("\\*\\*");
        TextExample textExample;
        if(!hasLabel){
            textExample = new TextExample(tokens[0]);
        }else {
            textExample = new TextExample(tokens[0],tokens[1]);
        }
        return textExample;
    }

}
