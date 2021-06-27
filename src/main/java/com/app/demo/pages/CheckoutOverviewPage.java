package com.app.demo.pages;

import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
    private CoreActions coreActions;

    public CheckoutOverviewPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".summary_subtotal_label")
    public WebElement labelItemSubtotal;

    @FindBy(how = How.ID, using = "finish")
    public WebElement btnFinish;

    public String getItemSubTotal() {
        return coreActions.getText(labelItemSubtotal).trim();
    }

    public void clickFinish() {
        coreActions.click(btnFinish);
    }

}
