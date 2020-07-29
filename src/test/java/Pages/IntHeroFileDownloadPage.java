package Pages;

   import org.openqa.selenium.WebElement;
   import org.openqa.selenium.support.FindBy;

   import java.util.List;

   import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class IntHeroFileDownloadPage extends Page{
    public IntHeroFileDownloadPage(){
        url = "http://the-internet.herokuapp.com/download";
    }

    @FindBy(xpath= "//h3[contains(text(),'File Downloader')]")
    private WebElement fileDownloaderMessage;

    @FindBy(xpath = "//a[contains(text(),'images.jpeg')]")
    private WebElement uploadedFileName;

    @FindBy(xpath= "//div[@class='example']/a")
    private List<WebElement> fileList;

      public String verifyHeadingAndUpladedImage() {
         assertThat(fileDownloaderMessage.isDisplayed()).isTrue();
          System.out.println();
          System.out.println(fileDownloaderMessage.getText());
          System.out.println(uploadedFileName.getText());
         return uploadedFileName.getText();
      }

      public void verifyFileIsPresent(){
          for (WebElement item:fileList){
              if ((item.getText()).equals(uploadedFileName.getText())){
                  System.out.println("uploaded file present: "+item.getText());
              }
          }
      }

      public void downloadFile(){
          uploadedFileName.click();
      }


    }
