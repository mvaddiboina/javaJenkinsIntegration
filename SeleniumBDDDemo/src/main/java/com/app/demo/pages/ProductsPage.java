package com.app.demo.pages;

import com.app.demo.utils.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private CoreActions coreActions;
    public HeaderPage header;

    public ProductsPage(WebDriver driver) {
        coreActions = new CoreActions(driver);
        header=new HeaderPage(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
    public WebElement firstProductAddToCart;


    @FindBy(how = How.CSS, using = ".inventory_item_price")
    public List<WebElement> labelPriceList;


    public void selectProduct() {
        coreActions.click(firstProductAddToCart);
    }

    public String getItemPrice() {
        return coreActions.getText(labelPriceList.get(0));
    }

}
