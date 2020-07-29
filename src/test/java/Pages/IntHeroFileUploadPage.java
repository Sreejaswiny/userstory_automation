package Pages;

import Pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class IntHeroFileUploadPage extends Page {
    public IntHeroFileUploadPage(){
        url = "http://the-internet.herokuapp.com/upload";
    }

    @FindBy(xpath= "//input[@id='file-upload']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadButton;

    @FindBy(xpath="//h3[contains(text(),'File Uploaded!')]")
    private WebElement fileUploadedMessage;

    @FindBy(xpath = "//div[@id='uploaded-files']")
    private WebElement fileNmae;

    public void clickChooseFile(){
        chooseFileButton.sendKeys("/Users/sreejaswiny/Downloads/images.jpeg");
    }

    public void clickUpload(){
        uploadButton.click();
    }

    public String verifyFileUploaded(){
//        String msg = fileUploadedMessage.getText();
//        System.out.println(msg);
//        msg.equals("File uploaded!");
        //[OR]
        assertThat(fileUploadedMessage.isDisplayed()).isTrue();
        return fileNmae.getText();

    }
}
