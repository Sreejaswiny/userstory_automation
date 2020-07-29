package definitions;

import Pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class PHPStepdefs {
    @Given("I goto {string} page")
    public void iGotoPage(String page) {
//        new PhpMainPage().open();

        switch (page.toLowerCase()){
            case "php":
               new PhpMainPage().open();
                break;
            case "internet herokuapp":
                new InternetHerokuappMainPage().open();
                break;

            case "costco":
                new CostcoHomePage().open();
                break;

                default:
                throw new RuntimeException("Not recognized page" + page);
        }

    }

    @And("I click on {string}")
    public void iClickOn(String tab) {
        new PhpMainPage().clickDemo(tab);
    }

    @Then("I navigate to front-end page")
    public void iNavigateToFrontEndPage() {
        new PhpDemoPage().clickFrontEnd();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int time) throws InterruptedException {
       Thread.sleep(time*1000);
    }

    @Then("I click on {string} section")
    public void iClickOnSection(String flights) {
        new PhpHomePage().clickTab(flights);
    }

    @And("I select {string} trip type")
    public void iSelectTripType(String trip) throws InterruptedException {
        new PhpHomePage().selectTripType(trip);
    }

    @When("I select {string} and {string} destinations and {string}")
    public void iSelectAndDestinationsAnd(String from, String to, String date) throws InterruptedException {
     new PhpHomePage().selectFromToAndDate(from,to,date);
     Thread.sleep(7000);
    }
}
