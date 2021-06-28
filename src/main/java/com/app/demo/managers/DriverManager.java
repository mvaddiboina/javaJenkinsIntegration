package com.app.demo.managers;

import com.app.demo.base.BrowserType;
import com.app.demo.base.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private WebDriver driver;
    public static BrowserType driverType; //FileReaderManager.getInstance().getConfigReader().getBrowser();
    private static EnvironmentType environmentType=FileReaderManager.getInstance().getConfigReader().getEnvironment();

    public DriverManager() {
        webDriverThreadLocal.set(createDriver());
    }

    public WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                if(driver==null)
                driver = createLocalDriver();
                break;
            case REMOTE:
                if(driver==null)
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.close();
            //driver.quit();
            webDriverThreadLocal.remove();
        } else
            throw new RuntimeException("WebDriver is null");
    }

}
