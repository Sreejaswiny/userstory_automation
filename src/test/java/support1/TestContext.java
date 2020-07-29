package support1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestContext {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static Actions getActions(){
        return new Actions(driver);
    }


    public static WebDriverWait getWait(){
        return new WebDriverWait(driver, 5);
    }
    public static WebDriverWait getWait(int timeout){
        return new WebDriverWait(driver, timeout);
    }


    public static JavascriptExecutor getExecutor(){
        return (JavascriptExecutor) driver;
    }

    public static void initialize()
    {
        initialize("chrome");
    }

     public static void initialize(String browser)
     {
         switch (browser) {
             case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                 break;
             default:
                 throw new RuntimeException("Driver is not implemented for: " + browser);
         }
     }
}