package learn.rubic.rubic_core.model;

import java.util.ArrayList;

/**
 * 加载数据集需要的信息
 * Created by Vigo on 16/8/25.
 */
public class DataSetInfo {

    private String data_path;

    private ArrayList<String> attributes;

    private String label_attribute;

    private int type;

    private boolean hasLabel = true;

    /**
     * 数据集没有标签
     * @param data_path
     * @param attributes
     */
    public DataSetInfo(String data_path, ArrayList<String> attributes, int type) {
       this(data_path, attributes, null, type);
        this.hasLabel = false;
    }

    /**
     * 数据集有标签
     * @param data_path
     * @param attributes
     * @param label_attribute
     */
    public DataSetInfo(String data_path, ArrayList<String> attributes, String label_attribute,
                       int type) {
        this.data_path = data_path;
        this.attributes = attributes;
        this.label_attribute = label_attribute;
        this.type = type;
    }


    public String getData_path() {
        return data_path;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public String getLabel_attribute() {
        return label_attribute;
    }

    public boolean isHasLabel() {
        return hasLabel;
    }

    public int getType() {
        return type;
    }
}
