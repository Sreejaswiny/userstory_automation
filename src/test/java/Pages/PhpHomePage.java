package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.apache.logging.log4j.core.async.AsyncLoggerContextSelector.isSelected;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class PhpHomePage extends Page{

    public PhpHomePage(){
        url = "https://www.phptravels.net/home";
    }


    @FindBy(xpath="//div[@id='s2id_location_from']")
    private WebElement from;

    @FindBy(xpath = "//div[@id='s2id_location_to']")
    private WebElement to;

    @FindBy(xpath = "//input[@id='FlightsDateStart']")
    private WebElement startDate;

    @FindBy(xpath = "//input[@id='FlightsDateEnd']")
    private WebElement returnDate;

    @FindBy(xpath = "//ul[@class='select2-results']/li")
    private WebElement fromDropdown;

    @FindBy(xpath = "//li/div[@class='select2-result-label']/span[text()='SFO']")
    private WebElement sfo;

    private WebElement tripType(String type){
        return getDriver().findElement(By.xpath("//label[contains(text(),'" +type+ "')]"));
    }

    private WebElement tab(String name) {
        return getDriver().findElement(By.xpath("//a[contains(text(),'" + name + "')]"));
    }

    public void clickTab(String tabName) {
        tab(tabName).click();
    }

    public void selectTripType(String trip){
        if (!(tripType(trip).isSelected())){
            tripType(trip).click();
        }
    }

    public void selectFromToAndDate(String fromPl, String to, String date){
//        from.sendKeys(fromPl);
//        getWait().until(ExpectedConditions.visibilityOf(fromDropdown));
//        getWait().until(ExpectedConditions.textToBePresentInElement(sfo,"SFO"));
        startDate.click();
        System.out.println("Hi");

    }
}
