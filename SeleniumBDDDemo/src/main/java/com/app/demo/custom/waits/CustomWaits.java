package com.app.demo.custom.waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWaits {

    private CustomWaits() {
    }

    public static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, WaiTime.MEDIUM_WAIT_TIME);
    }

    public static ExpectedCondition<Boolean> pageToLoad() {
        return driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public static ExpectedCondition<Boolean> titleToLoad(String title) {
        return driver -> driver.getTitle().contains(title);
    }
}
