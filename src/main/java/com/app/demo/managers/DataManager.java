package com.app.demo.managers;

import com.app.demo.base.DataContext;

public class DataManager {
    private static DataManager dataManager;
    private DataContext dataContext;

    private DataManager() {

    }

    public static DataManager getInstace() {
        if (dataManager == null)
            dataManager = new DataManager();
        return dataManager;
    }

    public DataContext dataContext() {
        if (dataContext == null)
            dataContext = new DataContext();
        return dataContext;
    }
}
