package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetAllProducts;

public class GetAllProductsSteps {

    @Steps
    GetAllProducts getAllProducts;

    @Given("user set API get all products")
    public void setAPIGetAllProducts() {
        getAllProducts.setAPIGetAllProducts();
    }

    @When("user send request to get all products")
    public void requestGetAllProducts() {
        getAllProducts.requestGetAllProducts();
    }

    @Then("user receive an information of all products")
    public void receiveAllProducts() {
        getAllProducts.receiveAllProducts();
    }
}
