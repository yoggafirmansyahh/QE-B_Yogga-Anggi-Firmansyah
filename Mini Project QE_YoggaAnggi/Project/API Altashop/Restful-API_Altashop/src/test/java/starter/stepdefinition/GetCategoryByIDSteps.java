package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetCategoryByID;

public class GetCategoryByIDSteps {

    @Steps
    GetCategoryByID getCategoryByID;

    @Given("user set API get category by ID")
    public void setAPIGetCategoryById() {
        getCategoryByID.setAPIGetCategoryById();
    }

    @When("user send request to get category by ID")
    public void requestGetCategoryById() {
        getCategoryByID.requestGetCategoryById();
    }

    @Then("user receive status code for get category by ID")
    public void receiveStatusCodeGetCategoryById() {
        getCategoryByID.receiveStatusCodeGetCategoryById();

    }

    @And("user receive an information of category based on ID")
    public void receiveCategoryById() {
        getCategoryByID.receiveCategoryById();
    }
}
