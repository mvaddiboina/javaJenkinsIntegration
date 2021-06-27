package com.app.demo.stepdef;

import com.app.demo.base.DataContext;
import com.app.demo.base.DataKeys;
import com.app.demo.base.TestContext;
import com.app.demo.managers.DataManager;
import com.app.demo.managers.PageObjectManager;
import com.app.demo.pojo.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyCartStepDef {
    private TestContext context;
    private PageObjectManager pom;
    private DataContext dataContext;

    public MyCartStepDef(TestContext context) {
        this.context = context;
        this.pom = context.getPageObjectManager();
        this.dataContext=context.getDataManager().dataContext();

    }

    @When("I add an item to car")
    public void i_add_an_item_to_car() {
        String itemPrice = pom.productPage().getItemPrice();
        dataContext.addData(DataKeys.PRODUCT_PRICE,itemPrice);
        System.out.println("Item price is: "+itemPrice);
        pom.productPage().selectProduct();
        pom.productPage().header.openBag();
        pom.yourCarPage().checkOut();
    }


}