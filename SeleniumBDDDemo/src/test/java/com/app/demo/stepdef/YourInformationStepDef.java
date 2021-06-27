package com.app.demo.stepdef;
import com.app.demo.base.DataContext;
import com.app.demo.base.DataKeys;
import com.app.demo.base.TestContext;
import com.app.demo.managers.PageObjectManager;
import com.app.demo.pojo.Customer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class YourInformationStepDef {
    private TestContext context;
    private PageObjectManager pom;
    private DataContext dataContext;

    public YourInformationStepDef(TestContext context) {
        this.context = context;
        this.pom = context.getPageObjectManager();
        this.dataContext=context.getDataManager().dataContext();
    }

    @When("fill the personal information")
    public void fill_the_personal_information() {
        Customer customer=Customer.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .zipCode("500049").build();
        dataContext.addData(DataKeys.CUSTOMER_DATA,customer);
        pom.yourInformationPage().fillPersonalInfo(customer);
    }

    @When("I place order with provided data")
    public void i_place_order_with_provided_data() {
        String subTotal = pom.checkoutOverviewPage().getItemSubTotal();
        System.out.println("Checkout overview page sub total: "+subTotal);
        assertThat("Product price verification failed",true,equalTo(subTotal.contains(dataContext.getData(DataKeys.PRODUCT_PRICE).toString())));
        pom.checkoutOverviewPage().clickFinish();
    }

    @Then("I see order is placed successfully")
    public void i_see_order_is_placed_successfully() {
        String orderSuccessMsg = pom.checkoutCompletePage().getOrderSuccessMsg();
        System.out.println("Order success message: "+orderSuccessMsg);
    }


}