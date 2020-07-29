package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static support.TestContext.getDriver;

public class GoogleStepdefs {
    @Given("I print Hello world")
    public void iPrintHelloWorld() {
        System.out.println("Hello");
    }

    @And("I open url {string}")
    public void iOpenUrl(String page) {
        switch (page){
            case "google":
                getDriver().get("https://www.google.com");
                break;
            case "quote":
            getDriver().get("https://skryabin.com/market/quote.html");
            break;

            default:
                // System.out.println("Not recognized page " +page);
                throw new RuntimeException("Not recognized page" + page); // To break the executing code or to show the error if given "Quote"

        }

    }
}
