import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static support.TestContext.*;

public class QuoteTest {

//    private WebDriver driver;

    @Before
        public void setup() {
//            WebDriverManager.chromedriver().setup();
//          driver = new ChromeDriver();
//           driver.get("https://skryabin.com/market/quote.html");

//        initialize("chrome");
        initialize();
        getDriver().get("https://skryabin.com/market/quote.html");

        }

    @Test
    public void quoteTest1() {
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Get a Quote";
        assertThat(actualTitle).isEqualTo(expectedTitle);
        System.out.println(actualTitle);
    }

   @Test
   public void quoteTest2() {
       getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Sreejaswiny");
       getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("Sree");
       getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("sreekrish28@gmail.com");
       String value = getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value");
       System.out.println(value);
    }

    @After
    public void tearDown() {
        getDriver().quit();
    }


}
