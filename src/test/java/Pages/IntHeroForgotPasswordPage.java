package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntHeroForgotPasswordPage extends Page {


    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath="//button[@id='form_submit']")
    private WebElement retrievePassword;

    @FindBy(xpath="//div[@class='example']/h2")
    private WebElement forgotPasswordHeading;

    @FindBy(xpath="//div[@id='content']")
    private WebElement verificationMsg;


    public String verifyHeading(){
        System.out.println(forgotPasswordHeading.getText());
        forgotPasswordHeading.isDisplayed();
        return forgotPasswordHeading.getText();
    }

    public void enterEmailAndClickRetrieve(String mail){
        emailField.sendKeys(mail);
        retrievePassword.click();
    }

    public String verfiyMailSent(){
        System.out.println(verificationMsg.getText());
        verificationMsg.isDisplayed();
       return verificationMsg.getText();
    }
}
