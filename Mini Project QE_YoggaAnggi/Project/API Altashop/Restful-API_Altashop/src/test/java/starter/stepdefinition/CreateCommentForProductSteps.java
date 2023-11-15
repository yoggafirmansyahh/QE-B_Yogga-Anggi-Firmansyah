package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_lol.AN;
import net.thucydides.core.annotations.Steps;
import starter.user.CreateCommentForProduct;

public class CreateCommentForProductSteps {

    @Steps
    CreateCommentForProduct createCommentForProduct;

    @Given("user set API to comment for product")
    public void setAPICommentProduct() {
        createCommentForProduct.setAPICommentProduct();
    }

    @When("user send request to comment product")
    public void requestCommentProduct() {
        createCommentForProduct.requestCommentProduct();
    }

    @And("product has commented")
    public void  productCommented() {
        createCommentForProduct.productComment();
    }
}
