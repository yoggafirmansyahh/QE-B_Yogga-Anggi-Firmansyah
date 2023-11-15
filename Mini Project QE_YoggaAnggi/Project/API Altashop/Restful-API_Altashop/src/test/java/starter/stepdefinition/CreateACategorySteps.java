package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateACategory;

public class CreateACategorySteps {
    @Steps
    CreateACategory createACategory;

    @Given("user set API to create a category")
    public void setAPICreateCategory() {
        createACategory.setAPICreateCategory();
    }

    @When("user send request to create a category")
    public void requestCreateCategory() {
        createACategory.requestCreateCategory();
    }

    @Then("user receive status code for create a category")
    public void receiveStatusCodeCreateCategory() {
        createACategory.receiveStatusCodeCreateCategory();
    }

    @And("category was created")
    public void categoryCreated() {
        createACategory.categoryCreated();
    }
}
