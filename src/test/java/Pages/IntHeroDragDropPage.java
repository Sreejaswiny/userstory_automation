package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.*;

public class IntHeroDragDropPage extends Page {

    @FindBy(xpath="//div[@id='column-a']")
    private WebElement columnA;

    @FindBy(xpath="//div[@id='column-b']")
    private WebElement columnB;

    public void dragAndDrop(String a, String b){
        getActions().dragAndDrop(columnA,columnB).build().perform();
        getWait(5);
        System.out.println(columnB.getText());

    }
}
