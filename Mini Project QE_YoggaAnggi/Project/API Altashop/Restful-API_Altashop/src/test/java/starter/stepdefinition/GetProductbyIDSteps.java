package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductbyID;

public class GetProductbyIDSteps {

    @Steps
    GetProductbyID getProductbyID;

    @Given("user set API get product by ID")
    public void setAPIEndpointGetProductbyID() {
        getProductbyID.setAPIEndpointGetProductbyID();
    }

    @When("user send request to get product by ID")
    public void sendGetProductByIdRequest() {
        getProductbyID.sendGetProductByIdRequest();
    }

    @Then("user receive status code 200 for get user by ID")
    public void receiveStatusCode200GetProductByID() {
        getProductbyID.receiveStatusCode200GetProductByID();
    }

    @And("user receive an information of product based on ID")
    public void receiveProductByID() {
        getProductbyID.receiveProductByID();
    }
}
