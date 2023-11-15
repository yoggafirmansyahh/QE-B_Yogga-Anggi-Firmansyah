package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetUserInformation;

public class GetUserInformationSteps {

    @Steps
    GetUserInformation getUserInformation;

    @Given("user set API get user information")
    public void setAPIGetUserInformation() {
        getUserInformation.setAPIGetUserInformation();
    }

    @When("user send request to get user information")
    public void requestGetUserInformation() {
        getUserInformation.requestGetUserInformation();
    }

    @Then("user receive status code 200 for get user information")
    public void receiveStatusCodeGetUserInformation() {
        getUserInformation.receiveStatusCodeGetUserInformation();
    }

    @And("user receive an information of user")
    public void receiveUserInformation() {
        getUserInformation.receiveUserInformation();
    }
}
