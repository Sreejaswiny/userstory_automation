package definitions;


import Pages.CostcoProductPage;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import java.net.URI;
public class TwilioCall extends CostcoProductPage {

    // Install the Java helper library from twilio.com/docs/java/install


        // Find your Account Sid and Token at twilio.com/console
        public static final String ACCOUNT_SID = "AC36bab0525ecb27f091dc3f55a07ba61f";
        public static final String AUTH_TOKEN = "d254d193853eab6e4fe26c45b32f20c7";
        public static void main(String[] args) {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Call call = Call.creator(
                    new com.twilio.type.PhoneNumber("+15109743920"),
                    new com.twilio.type.PhoneNumber("+18043619096"),
                    URI.create("http://demo.twilio.com/docs/voice.xml"))
                    .create();
            System.out.println(call.getSid());
        }
}
