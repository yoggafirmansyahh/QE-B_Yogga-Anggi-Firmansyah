package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteProduct;

public class DeleteProductSteps {

    @Steps
    DeleteProduct deleteProduct;

    @Given("user set API delete product")
    public void setAPIEndpointDeleteProduct() {
        deleteProduct.setAPIEndpointDeleteProduct();
    }

    @When("user send request to delete product")
    public void sendRequestDeleteProduct() {
        deleteProduct.sendRequestDeleteProduct();
    }

    @Then("user receive status code for deleted product")
    public void receiveStatusCodeDeleteProduct() {
        deleteProduct.receiveStatusCodeDeleteProduct();
    }

}
