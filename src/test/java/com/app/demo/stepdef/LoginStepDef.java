package com.app.demo.stepdef;

import com.app.demo.base.DataContext;
import com.app.demo.base.DataKeys;
import com.app.demo.base.TestContext;
import com.app.demo.managers.PageObjectManager;
import com.app.demo.pojo.Login;
import io.cucumber.java.en.Given;

public class LoginStepDef {
    private TestContext context;
    private PageObjectManager pom;
    private DataContext dataContext;

    public LoginStepDef(TestContext context) {
        this.context = context;
        this.pom = context.getPageObjectManager();
        this.dataContext = context.getDataManager().dataContext();
    }

    @Given("I am login into the website")
    public void i_am_login_into_the_website() {
        Login login = Login.builder().userName("standard_user").password("secret_sauce").build();
        dataContext.addData(DataKeys.LOGIN_DATA,login);
        pom.loginPage().login(login);
    }


}