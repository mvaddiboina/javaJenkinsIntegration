package com.app.demo.pages;

import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
    private CoreActions coreActions;

    public HeaderPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".shopping_cart_link")
    public WebElement iconBag;


    public void openBag() {
        coreActions.click(iconBag);
    }

}
