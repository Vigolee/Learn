package learn.rubic.rubic_framework.result_data;

import learn.rubic.rubic_framework.train_data.DataStruct;

import java.util.ArrayList;

/**
 * 矩阵型结果集
 * Created by Vigo on 16/8/25.
 */
public class ResultMatrixStruct extends DataStruct{

    // 属性值集合，
    private ArrayList<String> attributes;

    // 标签属性
    private String label_attribute;

    // 结果属性
    private String result_attribute;

    public ResultMatrixStruct(ResultMatrixStructBuilder builder) {
        this.attributes = builder.attributes;
        this.label_attribute = builder.label_attribute;
        this.result_attribute = builder.result_attribute;
    }

    static class ResultMatrixStructBuilder {

        // 属性值集合，
        private ArrayList<String> attributes;

        // 标签属性
        private String label_attribute;

        // 结果属性
        private String result_attribute;

        // 每个Example为一行
        private ArrayList<ResultMatrixExample> resultMatrixExamples;

        public ResultMatrixStructBuilder setAttributes(ArrayList<String> attributes) {
            this.attributes = attributes;
            return this;
        }

        public ResultMatrixStructBuilder setLabel_attribute(String label_attribute) {
            this.label_attribute = label_attribute;
            return this;
        }

        public ResultMatrixStructBuilder setResult_attribute(String result_attribute) {
            this.result_attribute = result_attribute;
            return this;
        }

        public ResultMatrixStructBuilder setResultMatrixExamples(ArrayList<ResultMatrixExample> resultMatrixExamples) {
            this.resultMatrixExamples = resultMatrixExamples;
            return this;
        }

        public ResultMatrixStruct builder(){
            return new ResultMatrixStruct(this);
        }
    }

}
