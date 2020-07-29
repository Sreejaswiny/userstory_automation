package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class CostcoResultsPage  extends Page{


    @FindBy(xpath="//input[@name='sign-in-to-buy']")
    private WebElement signInForPrice;

    @FindBy(xpath = "//div[@id='product-page']")
    private WebElement productPageContainer;

    private WebElement itemName(String name){
        return getDriver().findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
    }

    public void clickItem(String item) throws InterruptedException {
        Thread.sleep(7000);
        itemName(item).click();
        Thread.sleep(7000);
//        getWait().until(ExpectedConditions.visibilityOf(productPageContainer));
    }
}
