package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.getDriver;

public class IntHeroFloatingMenuPage extends Page {

    @FindBy(xpath="//div[@id='menu']")
    private WebElement floatingMenu;

    private WebElement pageHeading(){
        return getDriver().findElement(By.xpath("//div[@class='example']/h3"));
    }

    private WebElement menuOptions(String menu){
     return getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(text(),'"+menu+"')]"));
    }

    public String verifyPageHeading(){
        System.out.println(pageHeading().getText());
        return pageHeading().getText();
    }

    public String menuIsPresent(String menu){
        menuOptions(menu).isDisplayed();
        System.out.println(menuOptions(menu).getText());
      return  menuOptions(menu).getText();
    }


    public void scrollByDefinedPixel(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1500)");
    }

    public void scrollToPixelOfThePage(String count) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0, " + count + ")");
        System.out.println("Scrolled down");
        Thread.sleep(2000);
        floatingMenu.isDisplayed();
        js.executeScript("window.scrollBy(0, -" + count + ")");
        System.out.println("Scrolled up!");
        Thread.sleep(2000);
    }
    public void scrollToEndOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        js.executeScript("window.scrollTo(1500,document.body.scrollHeight)");
//        js.executeScript("window.scrollBy(0,-2500)");
        System.out.println("hi");
    }

    public void scrollUpToPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,-1500)");
    }

    public void scrollUptoStartOfPage(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

    }

//    public String verifyMenuOptions(String menu){
//////        menuOptions(menu).isDisplayed();
////        System.out.println(menuOptions(menu).getAttribute("text"));
////        menuOptions(menu).getAttribute("text").equals(menu);
//////        return menuOptions(menu).getText();
////        return menuOptions(menu).getAttribute("text");
////    }


}
