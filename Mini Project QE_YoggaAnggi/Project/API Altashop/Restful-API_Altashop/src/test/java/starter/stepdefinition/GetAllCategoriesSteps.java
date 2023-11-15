package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetAllCategories;

public class GetAllCategoriesSteps {

    @Steps
    GetAllCategories getAllCategories;

    @Given("user set API get all categories")
    public void setAPIGetAllCategories() {
        getAllCategories.setAPIGetAllCategories();
    }

    @When("user send request to get all categories")
    public void requestAllCategories() {
        getAllCategories.requestAllCategories();
    }

    @Then("user receive an information of all categories")
    public void receiveAllCategories() {
        getAllCategories.receiveAllCategories();
    }
}
