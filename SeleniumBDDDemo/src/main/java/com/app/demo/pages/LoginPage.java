package com.app.demo.pages;

import com.app.demo.custom.waits.CustomWaits;
import com.app.demo.pojo.Login;
import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private CoreActions coreActions;

    public LoginPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        CustomWaits.wait(driver).until(CustomWaits.pageToLoad());
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "user-name")
    public WebElement txtEmail;

    @FindBy(how = How.ID, using = "password")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "login-button")
    public WebElement btnLogin;


    public void login(Login login) {
        coreActions.type(txtEmail, login.getUserName());
        coreActions.type(txtPassword, login.getPassword());
        coreActions.click(btnLogin);
    }

}
