package learn.rubic.rubic_framework.train_data;

import java.util.ArrayList;

/**
 * 输入数据
 * Created by Vigo on 16/8/26.
 */
public class DataSet {

    private ArrayList<Integer> data_type;

    private ArrayList<DataStruct> input;


    public DataSet() {
        this.data_type = new ArrayList<Integer>();
        this.input = new ArrayList<DataStruct>();
    }

    public DataSet(ArrayList<Integer> data_type, ArrayList<DataStruct> input) {
        this.data_type = data_type;
        this.input = input;
    }

    public void addDataStruct(DataStruct dataStruct, int type){
        this.data_type.add(type);
        this.input.add(dataStruct);
    }

    public ArrayList<Integer> getData_type() {
        return data_type;
    }

    public ArrayList<DataStruct> getDatas() {
        return input;
    }
}
