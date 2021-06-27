package com.app.demo.base;

import com.app.demo.managers.DriverManager;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class WebDriverListener implements IInvokedMethodListener {
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            String browserName = (String) iInvokedMethod.getTestMethod().getXmlTest().getLocalParameters().get("browser");
            if (browserName == null || browserName.equalsIgnoreCase("chrome"))
                DriverManager.driverType = BrowserType.CHROME;
            else if (browserName.equalsIgnoreCase("firefox"))
                DriverManager.driverType = BrowserType.FIREFOX;
            else
                throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);

        }
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
        }
    }
}
