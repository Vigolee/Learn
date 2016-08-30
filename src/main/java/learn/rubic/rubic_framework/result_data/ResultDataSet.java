package learn.rubic.rubic_framework.result_data;

import learn.rubic.rubic_framework.train_data.DataStruct;

import java.util.ArrayList;

/**
 * 运行结果返回类
 * Created by Vigo on 16/8/26.
 */
public class ResultDataSet {

    private ArrayList<Integer> data_types;

    private ArrayList<DataStruct> results;

    private Object model;

    public ResultDataSet(){
        this.data_types  = new ArrayList<Integer>();
        this.results = new ArrayList<DataStruct>();
    }

    public void addDataStruct(DataStruct dataStruct, int type) {
        this.data_types.add(type);
        this.results.add(dataStruct);
    }

    public void saveModel(Object model) {
        this.model = model;
    }

    public ArrayList<Integer> getData_types() {
        return data_types;
    }

    public ArrayList<DataStruct> getDataStructs() {
        return results;
    }
}
