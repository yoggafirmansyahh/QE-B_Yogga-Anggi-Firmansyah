package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateNewProduct;

public class CreateNewProductSteps {
    @Steps
    CreateNewProduct createNewProduct;

    @Given("user set API to create new product")
    public void setAPICreateProduct() {
        createNewProduct.setAPICreateProduct();
    }

    @When("user send request to create new product")
    public void requestCreateProduct() {
        createNewProduct.requestCreateProduct();
    }

    @And("new product was created")
    public void productCreated() {
        createNewProduct.productCreated();
    }
}
