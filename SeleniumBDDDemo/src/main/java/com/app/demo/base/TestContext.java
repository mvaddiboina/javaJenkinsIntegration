package com.app.demo.base;
import com.app.demo.managers.DataManager;
import com.app.demo.managers.DriverManager;
import com.app.demo.managers.PageObjectManager;

public class TestContext {
    private DriverManager webDriverManager;
    private PageObjectManager pageObjectManager;
    private DataManager dataManager;

    public TestContext(){
        webDriverManager = new DriverManager();
        pageObjectManager =  new PageObjectManager(webDriverManager.getDriver());
        dataManager=DataManager.getInstace();
    }

    public DriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
