package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateNewOrder;

public class CreateNewOrderSteps {

    @Steps
    CreateNewOrder createNewOrder;

    @Given("user set API to create new order")
    public void setAPIEndpointCreateOrder (){
        createNewOrder.setAPIEndpointCreateOrder();
    }

    @When("user send request to create new order")
    public void requestCreateNewOrder() {
        createNewOrder.requestCreateNewOrder();
    }

    @And("new order was created")
    public void newOrderCreated() {
        createNewOrder.newOrderCreated();
    }
}
