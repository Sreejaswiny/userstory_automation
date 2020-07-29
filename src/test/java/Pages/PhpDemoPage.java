package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class PhpDemoPage extends Page {

    @FindBy(xpath = "//div[@class='row']/a/small[contains(text(),'http://www.phptravels.net')]")
    private WebElement frontEnd;

    @FindBy(xpath = "//small[text()='http://www.phptravels.net/admin']")
    private WebElement backEnd;

    public void clickFrontEnd(){
        String originalWindow = getDriver().getWindowHandle();
        System.out.println(originalWindow);
        frontEnd.click();
        for (String handle:getDriver().getWindowHandles()){
            getDriver().switchTo().window(handle);
        }
        getWait(10).until(ExpectedConditions.titleIs("PHPTRAVELS | Travel Technology Partner"));
        assertThat(getDriver().getTitle()).isEqualTo("PHPTRAVELS | Travel Technology Partner");
        //title[contains(text(),'PHPTRAVELS | Travel Technology Partner')]


    }

}
