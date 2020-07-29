package definitions;

import support.RESTWrapper;
import cucumber.api.java.en.Given;

import java.util.Map;

import static support.TestContext.getData;

public class RESTStepdefs {
    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {
        Map<String,String> user = getData(role);
        new RESTWrapper().login(user);
    }
}
