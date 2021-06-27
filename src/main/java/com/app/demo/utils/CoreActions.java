package com.app.demo.utils;

import com.app.demo.custom.waits.WaiTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreActions {
    private WebDriver driver;

    public CoreActions(WebDriver driver) {
        this.driver = driver;
    }

    public void type(WebElement element, String data) {
        waitForElementToVisible(element);
        element.clear();
        element.sendKeys(data);
    }

    public void click(WebElement element) {
        waitForElementToClick(element);
        element.click();
    }

    public void waitForElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WaiTime.MEDIUM_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WaiTime.MEDIUM_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getText(WebElement element)
    {
        waitForElementToVisible(element);
        return element.getText().trim();
    }


}
