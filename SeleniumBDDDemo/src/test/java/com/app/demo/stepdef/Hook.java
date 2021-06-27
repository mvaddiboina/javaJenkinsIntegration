package com.app.demo.stepdef;
import com.app.demo.base.TestContext;
import com.app.demo.custom.waits.WaiTime;
import com.app.demo.managers.FileReaderManager;
import io.cucumber.java.*;

import java.util.concurrent.TimeUnit;

public class Hook {

    private TestContext context;

    public Hook(TestContext context) {
        this.context = context;
    }

    @Before
    public void InitializeTest() {
        context.getWebDriverManager().getDriver();
        context.getWebDriverManager().getDriver().get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
        context.getWebDriverManager().getDriver().manage().timeouts().pageLoadTimeout(WaiTime.MEDIUM_WAIT_TIME, TimeUnit.SECONDS);
    }


    @After
    public void closeDriverObjects() {
        context.getWebDriverManager().quitDriver();
    }

}
