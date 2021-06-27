package com.app.demo.pages;

import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YourCarPage {
    private CoreActions coreActions;

    public YourCarPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "checkout")
    public WebElement btnCheckout;


    public void checkOut() {
        coreActions.click(btnCheckout);
    }

}
