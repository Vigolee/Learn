package learn.rubic.rubic_framework.train_data;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵型数据
 * Created by Vigo on 16/8/25.
 */
public class MatrixStruct extends DataStruct {

    // 属性值集合，
    private ArrayList<String> attributes;

    // 标签属性
    private String label_attribute;

    // 每个Example为一行
    private ArrayList<MatrixExample> matrixExamples;

    public MatrixStruct(){
        this.attributes = new ArrayList<String>();
        this.matrixExamples = new ArrayList<MatrixExample>();
    }

    public void setAttributes(ArrayList<String> attributes){
        this.attributes = attributes;
    }

    public void setMatrixExamples(ArrayList<MatrixExample> matrixExamples) {
        this.matrixExamples = matrixExamples;
    }

    public void setLabel_attribute(String label_attribute){
        this.label_attribute = label_attribute;
    }

    public List<MatrixExample> getMatrixExamples(){
        return matrixExamples;
    }

    public ArrayList<String> getAttributes(){
        return attributes;
    }

    public String getLabel_attribute(){
        return label_attribute;
    }

    @Override
    public String toString() {
        return "MatrixStruct{" +
                "attributes=" + attributes +
                ", label_attribute='" + label_attribute + '\'' +
                ", matrixExamples=" + matrixExamples +
                '}';
    }
}
