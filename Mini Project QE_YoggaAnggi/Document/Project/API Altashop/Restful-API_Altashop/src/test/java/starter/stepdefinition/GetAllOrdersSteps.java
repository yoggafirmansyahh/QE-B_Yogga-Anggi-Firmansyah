package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetAllOrders;

public class GetAllOrdersSteps {

    @Steps
    GetAllOrders getAllOrders;

    @Given("user set API get all orders")
    public void setAPIGetAllOrders() {
        getAllOrders.setAPIGetAllOrders();
    }

    @When("user send request to get all orders")
    public void requestGetAllOrders() {
        getAllOrders.requestGetAllOrders();
    }

    @Then("user receive an information of all orders")
    public void receiveAllOrders() {
        getAllOrders.receiveAllOrders();
    }
}
