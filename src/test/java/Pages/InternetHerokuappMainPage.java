package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class InternetHerokuappMainPage extends Page {
    public InternetHerokuappMainPage(){
        url = "http://the-internet.herokuapp.com/";
    }

    private WebElement link(String linkName){
        return getDriver().findElement(By.xpath("//a[contains(text(),'" +linkName+ "')]"));
    }

    public String clickLink(String lName){
        link(lName).click();
        switch (lName) {
            case "File Upload":
            getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/upload"));
            break;

            case "File Download":
                getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/download"));
                break;

            case "Floating Menu":
                getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/floating_menu"));
                break;

            case "Forgot Password":
                getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/forgot_password"));
                break;

            case "Drag and Drop":
                getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/drag_and_drop"));
                break;

            case "Hovers":
                getWait().until(ExpectedConditions.urlToBe("http://the-internet.herokuapp.com/hovers"));
                break;

                default:throw new RuntimeException("Page not recognized");
        }
        return getDriver().getCurrentUrl();
    }

}
