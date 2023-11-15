package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetOrderbyID;

public class GetOrderbyIDSteps {

    @Steps
    GetOrderbyID getOrderbyID;

    @Given("user set API get order by ID")
    public void setAPIGetOrderByID() {
        getOrderbyID.setAPIGetOrderByID();
    }

    @When("user send request to get order by ID")
    public void requestGetOrderByID() {
        getOrderbyID.requestGetOrderByID();
    }

    @Then("user receive status code for get order by ID")
    public void receiveStatusCodeGetOrderById() {
        getOrderbyID.receiveStatusCodeGetOrderById();
    }

    @And("user receive an information of order based on ID")
    public void receiveInformationOrder() {
        getOrderbyID.receiveInformationOrder();
    }
}
