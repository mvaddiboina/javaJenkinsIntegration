package com.app.demo.pages;

import com.app.demo.pojo.Customer;
import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class YourInformationPage {
    private CoreActions coreActions;

    public YourInformationPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "first-name")
    public WebElement txtFirstName;

    @FindBy(how = How.ID, using = "last-name")
    public WebElement txtLastName;

    @FindBy(how = How.ID, using = "postal-code")
    public WebElement txtZipCode;

    @FindBy(how = How.ID, using = "continue")
    public WebElement btnContinue;


    public void fillPersonalInfo(Customer customer) {
        coreActions.type(txtFirstName, customer.getFirstName());
        coreActions.type(txtLastName, customer.getLastName());
        coreActions.type(txtZipCode, customer.getZipCode());
        coreActions.click(btnContinue);
    }

}
