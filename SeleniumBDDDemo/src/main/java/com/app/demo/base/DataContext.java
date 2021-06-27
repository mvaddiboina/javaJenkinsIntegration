package com.app.demo.base;
import java.util.HashMap;
import java.util.Map;

public class DataContext {
    private Map<DataKeys, Object> dataMap;

    public DataContext() {
        dataMap = new HashMap<>();
    }

    public void addData(DataKeys key, Object data) {
        dataMap.put(key, data);
    }

    public Object getData(DataKeys key) {
        return dataMap.get(key);
    }

}
