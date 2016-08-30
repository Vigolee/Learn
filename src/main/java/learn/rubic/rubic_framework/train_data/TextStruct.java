package learn.rubic.rubic_framework.train_data;

import java.util.ArrayList;

/**
 * 文本型数据
 * Created by Vigo on 16/8/25.
 */
public class TextStruct extends DataStruct{

    private String attribute;

    // 标签属性
    private String label_attribute;

    private ArrayList<TextExample> textExamples;

    public TextStruct() {
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setTextExamples(ArrayList<TextExample> textExamples) {
        this.textExamples = textExamples;
    }

    public void setLabel_attribute(String label_attribute){
        this.label_attribute = label_attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getLabel_attribute() {
        return label_attribute;
    }

    public ArrayList<TextExample> getTextExamples() {
        return textExamples;
    }

    @Override
    public String toString() {
        return "TextStruct{" +
                "attribute='" + attribute + '\'' +
                ", label_attribute='" + label_attribute + '\'' +
                ", textExamples=" + textExamples +
                '}';
    }
}
