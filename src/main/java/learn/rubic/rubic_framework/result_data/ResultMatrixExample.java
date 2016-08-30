package learn.rubic.rubic_framework.result_data;

import java.util.ArrayList;

/**
 * 存储一行矩阵型结果数据
 * Created by Vigo on 16/8/25.
 */
public class ResultMatrixExample extends ArrayList<String> {

    private String label;

    private String result;

    public void setLabel(String label){
        this.label = label;
    }

    public void setReslut(String result) {
        this.result = result;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {

        return "ResultMatrixExample{" +
                "label='" + label + '\'' + "result=" +
                result + '\'' +
                "content=" +
                super.toString() +
                "}\n";
    }
}
