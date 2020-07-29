package Pages;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URI;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CostcoProductPage extends Page {

    @FindBy(xpath= "//div[@id='productImageOverlay']/img[@title='Out of Stock']")
    private WebElement productOutOfStockImage;

    @FindBy(xpath="//img[@id='initialProductImage']")
    private WebElement productImage;

    public String verifyAvailabilityOfItem(){
        if (productOutOfStockImage.isDisplayed()) {
            assertThat(productOutOfStockImage.isDisplayed()).isTrue();
            System.out.println("Stock Availability: " + productOutOfStockImage.getAttribute("alt"));
//            System.out.println(productOutOfStockImage.getAttribute("alt"));
            return productOutOfStockImage.getAttribute("alt");
        }

        else {
            assertThat(productOutOfStockImage.isDisplayed()).isFalse();
            System.out.println("Stock Availability: " + productImage.getAttribute("alt"));
//            System.out.println(productImage.getAttribute("alt"));
            return productImage.getAttribute("alt");
        }

    }

    public void twilioCall(){
        final String ACCOUNT_SID = "AC36bab0525ecb27f091dc3f55a07ba61f";
        final String AUTH_TOKEN = "d254d193853eab6e4fe26c45b32f20c7";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Call call = Call.creator(
                new com.twilio.type.PhoneNumber("+15109743920"),
                new com.twilio.type.PhoneNumber("+18043619096"),
                URI.create("http://demo.twilio.com/docs/voice.xml"))
                .create();
        System.out.println(call.getSid());
    }



}
