package definitions;

import Pages.CostcoHomePage;
import Pages.CostcoProductPage;
import Pages.CostcoResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CostcoStepdefs {
    @When("I search for {string} item")
    public void iSearchForItem(String item) throws InterruptedException {
    new CostcoHomePage().searchItem(item);
    }

    @Then("I click on the item {string}")
    public void iClickOnTheItem(String itemName) throws InterruptedException {
        new CostcoResultsPage().clickItem(itemName);
        System.out.println("");
    }

    @And("I verify the availability of item")
    public void iVerifyTheAvailabilityOfItem() {
        String actualAvailability = new CostcoProductPage().verifyAvailabilityOfItem();
        if (!(actualAvailability.equals("Out of Stock"))){
            new CostcoProductPage().twilioCall();
        }
    }
}
