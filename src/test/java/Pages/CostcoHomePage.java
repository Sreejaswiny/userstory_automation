package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static support.TestContext.*;

public class CostcoHomePage extends Page {

    public CostcoHomePage(){
        url = "https://www.costco.com/";

    }

    @FindBy(xpath="//input[@id='search-field']")
    private WebElement searchInputField;

    @FindBy(xpath="//div[@class='flex-child']//button[@class='btn search-ico-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-list grid']")
    private WebElement searchResultsContainer;

    public void searchItem(String item) throws InterruptedException {
        searchInputField.sendKeys(item);
        searchButton.click();
        getWait().until(ExpectedConditions.visibilityOf(searchResultsContainer));
//        searchInputField.sendKeys(Keys.ENTER);

    }
}
