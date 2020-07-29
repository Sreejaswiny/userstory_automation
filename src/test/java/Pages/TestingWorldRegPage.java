package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static support1.TestContext.getWait;
import static support1.TestContext.initialize;

public class TestingWorldRegPage extends Page{

    public TestingWorldRegPage(){
        url = "https://thetestingworld.com/testings/";
    }
    //select[@id='cityId']/option[contains(text(),'Please wait for 3 sec..')]

    @FindBy(xpath ="//input[@name='fld_username']")
    private WebElement userName;

    @FindBy(xpath = "//input[@name='fld_email']")
    private WebElement email;

    @FindBy(xpath= "//input[@name='fld_email']")
    private WebElement password;

    @FindBy(xpath = "//input[@name='fld_cpassword']")
    private WebElement comfirmPassword;

    @FindBy(xpath = "//input[@id='datepicker']")
    private WebElement datePicker;

    @FindBy(xpath = "//input[@name='phone']")
     private WebElement phone;

    @FindBy(xpath = "//input[@name='address']")
    private WebElement address;

    @FindBy(xpath="//input[@value='home']")
    private WebElement homeRadioButton;

    @FindBy(xpath = "//select[@name='sex']")
    private WebElement gender;

    @FindBy(xpath = "//select[@name='country']")
    private WebElement country;

    @FindBy(xpath = "//select[@id='stateId']")
    private WebElement state;

    @FindBy(xpath = "//select[@id='cityId']")
    private WebElement city;

    @FindBy(xpath = "//input[@name='zip']")
    private WebElement zip;

    @FindBy(xpath = "//select[@id='cityId']/option[text()='Please wait for 3 sec..']")
    private WebElement cityWait;

    @FindBy(xpath = "//div[@class='btn']/input[@type='checkbox']")
    private WebElement checkBoxButton;

    @FindBy(xpath = "//a[@class='displayPopup']")
    private WebElement readDetail;



    public void fillRegisterationDetails(){
        userName.sendKeys("Sreejaswiny");
        email.sendKeys("sreekrish28@gmail.com");
        password.sendKeys("55555");
        comfirmPassword.sendKeys("55555");
        datePicker.sendKeys("06/28/2020");
        phone.sendKeys("7708992602");
        address.sendKeys("2250 Monroe st");
    }

    public void selectHomeRadioButton(){
        if (!homeRadioButton.isSelected()){
            homeRadioButton.click();
        }
    }

    public void selectGender(){
        List<WebElement> options = new Select(gender).getOptions();
        for (WebElement item: options){
            System.out.println(item.getText());
        }
        new Select(gender).selectByVisibleText("Female");
    }

    public void selectCountry(){
        new Select(country).selectByVisibleText("United States");
//        List<WebElement>options = new Select(country).getOptions();
//        for (WebElement item: options){
//            System.out.println(item.getText());
//        }
    }

    public void selectState() throws InterruptedException {
        By stateLocator = By.xpath("//select[@id='stateId']");
        getWait().until(ExpectedConditions.invisibilityOfElementWithText(stateLocator,"Please wait for 3 sec.."));
        getWait().until(ExpectedConditions.textToBePresentInElement(state, "Select State"));
        new Select(state).selectByVisibleText("California");
    }
    public void selectCity(){
         By cityLocator = By.xpath("//select[@id='cityId']");
         getWait().until(ExpectedConditions.invisibilityOfElementWithText(cityLocator,"Please wait for 3 sec.."));
//        getWait().until(ExpectedConditions.invisibilityOf(cityWait));
        getWait().until(ExpectedConditions.textToBePresentInElement(city, "Select City"));
        new Select(city).selectByVisibleText("Santa Clara");
        System.out.println(city.getAttribute("value"));
    }

    public void zipcode(){
        zip.sendKeys("95050");
    }

    public void selectCheckbox(){
        if (!checkBoxButton.isSelected()){
            checkBoxButton.click();
        }
        System.out.println(readDetail.getText());
    }

}
