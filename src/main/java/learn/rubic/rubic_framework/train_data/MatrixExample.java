package learn.rubic.rubic_framework.train_data;

import java.util.ArrayList;

/**
 * 存储一行矩阵数据
 * Created by Vigo on 16/8/25.
 */
public class MatrixExample extends ArrayList<String> {

    private String label;

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {

        return "MatrixExample{" +
                "label='" + label + '\'' + "content=" +
                super.toString() +
                "}\n";
    }
}
