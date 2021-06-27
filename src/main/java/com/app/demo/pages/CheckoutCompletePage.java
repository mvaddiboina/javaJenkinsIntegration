package com.app.demo.pages;

import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private CoreActions coreActions;

    public CheckoutCompletePage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#checkout_complete_container>h2")
    public WebElement labelOrderSuccessMsg;

    public String getOrderSuccessMsg() {
        return coreActions.getText(labelOrderSuccessMsg).trim();
    }

}
