package definitions;

import Pages.*;
import cucumber.api.java.en.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;

public class InternetHerokuappStepdefs {
    @Then("I click on {string} link")
    public void iClickOnLink(String link) {

//      new InternetHerokuappMainPage().clickLink(link);
//        [OR]

        String expectedUrl;
        switch (link){
            case "File Upload":
                expectedUrl = "http://the-internet.herokuapp.com/upload";
                break;

            case "File Download":
                expectedUrl = "http://the-internet.herokuapp.com/download";
                break;

            case "Floating Menu":
                expectedUrl = "http://the-internet.herokuapp.com/floating_menu";
                break;

            case "Forgot Password":
                expectedUrl = "http://the-internet.herokuapp.com/forgot_password";
                break;

            case "Drag and Drop":
                expectedUrl = "http://the-internet.herokuapp.com/drag_and_drop";
                break;

            case "Hovers":
                expectedUrl = "http://the-internet.herokuapp.com/hovers";
                break;


                default:throw new RuntimeException("url not recognized");
        }
        String actualUrl =  new InternetHerokuappMainPage().clickLink(link);
        assertThat(expectedUrl).isEqualTo(actualUrl);
        System.out.println("actualUrl: "+actualUrl);
        System.out.println("expectedUrl: "+expectedUrl);
        System.out.println();
    }

    @Then("I click on the Choose File button")
    public void iClickOnTheChooseFileButton() {
        new IntHeroFileUploadPage().clickChooseFile();
    }

    @And("I upload the file")
    public void iUploadTheFile() {
        new IntHeroFileUploadPage().clickUpload();
    }

    @And("I verify file is uploaded")
    public void iVerifyFileIsUploaded() {
        String actualFileName = new IntHeroFileUploadPage().verifyFileUploaded();
        String expectedFileName = "images.jpeg";
        assertThat(expectedFileName).isEqualTo(actualFileName);
    }

    @Then("I verify the heading of the page and uploaded file is present")
    public void iVerfifyTheHeadingOfThePageAndUploadedFileIsPresent() {
        new IntHeroFileDownloadPage().verifyHeadingAndUpladedImage();
        new IntHeroFileDownloadPage().verifyFileIsPresent();
    }

    @Then("I download the file")
    public void iDownloadTheFile() {
        new IntHeroFileDownloadPage().downloadFile();
    }

    @Then("I verify the heading of the page is {string}")
    public void iVerifyTheHeadingOfThePageIs(String heading) {
        String actualHeading= new IntHeroFloatingMenuPage().verifyPageHeading();
        assertThat(heading).isEqualTo(actualHeading);
    }

    @And("I verify {string},{string},{string} and {string} menus are present")
    public void iVerifyAndMenusArePresent(String home, String news, String contact, String about) {
      assertThat(new IntHeroFloatingMenuPage().menuIsPresent(home)).isEqualTo(home);
      assertThat(new IntHeroFloatingMenuPage().menuIsPresent(news)).isEqualTo(news);
      assertThat(new IntHeroFloatingMenuPage().menuIsPresent(contact)).isEqualTo(contact);
      assertThat(new IntHeroFloatingMenuPage().menuIsPresent(about)).isEqualTo(about);
    }

    @When("I scroll to the end of the page")
    public void iScrollToTheEndOfThePage() {
        new IntHeroFloatingMenuPage().scrollToEndOfPage();
    }

    @Then("I verify that {string},{string},{string} and {string} menus are floating")
    public void iVerifyThatAndMenusAreFloating(String home, String news, String contact, String about) {
        assertThat(new IntHeroFloatingMenuPage().menuIsPresent(home)).isEqualTo(home);
        assertThat(new IntHeroFloatingMenuPage().menuIsPresent(news)).isEqualTo(news);
        assertThat(new IntHeroFloatingMenuPage().menuIsPresent(contact)).isEqualTo(contact);
        assertThat(new IntHeroFloatingMenuPage().menuIsPresent(about)).isEqualTo(about);
    }

    @When("I scroll down to the defined pixel of the page")
    public void iScrollDownToTheDefinedPixelOfThePage() {
        new IntHeroFloatingMenuPage().scrollByDefinedPixel();
    }

    @And("I scroll up to the start of the page")
    public void iScrollUpToTheStartOfThePage() {
        new IntHeroFloatingMenuPage().scrollUptoStartOfPage();
        System.out.println("Hello");
    }

    @And("I scroll up to the page")
    public void iScrollUpToThePage() {
        new IntHeroFloatingMenuPage().scrollUpToPage();
    }

    @When("I scroll to pixel {string} of the page")
    public void iScrollToPixelOfThePage(String count) throws InterruptedException {
        new IntHeroFloatingMenuPage().scrollToPixelOfThePage(count);
    }


    @Then("I verify the heading of the page is that {string}")
    public void iVerifyTheHeadingOfThePageIsThat(String heading) {
        assertThat(new IntHeroForgotPasswordPage().verifyHeading()).isEqualTo(heading);
    }

    @When("I enter the email address as {string} and I click retrieve password button")
    public void iEnterTheEmailAddressAsAndIClickRetrievePasswordButton(String email) {
        new IntHeroForgotPasswordPage().enterEmailAndClickRetrieve(email);
    }

    @Then("I verify that link sent to email")
    public void iVerifyThatLinkSentToEmail() {
        new IntHeroForgotPasswordPage().verfiyMailSent();
    }

    @And("I drag {string} and drop it in {string}")
    public void iDragAndDropItIn(String A, String B) {
        new IntHeroDragDropPage().dragAndDrop(A,B);

    }

}
