package Pages;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class PhpMainPage extends Page {

    public PhpMainPage(){
        url = "https://phptravels.com/";
    }

    private WebElement tab(String tab){
        return getDriver().findElement(By.xpath("//a[@class='yx-njm'][contains(text(),'" + tab + "')]"));
    }


    public void clickDemo(String tabName){
        tab(tabName).click();
//        getWait(10).until(ExpectedConditions.urlToBe(url+tabName.toLowerCase())); [OR]
        switch (tabName) {
            case "Demo":
            getWait(10).until(ExpectedConditions.urlToBe("https://phptravels.com/demo"));
            break;

            case "Pricing":
                getWait(10).until(ExpectedConditions.urlToBe(url+"order"));
                break;

                default:
                    throw new RuntimeException("Page not recognized");
        }
    }


}
