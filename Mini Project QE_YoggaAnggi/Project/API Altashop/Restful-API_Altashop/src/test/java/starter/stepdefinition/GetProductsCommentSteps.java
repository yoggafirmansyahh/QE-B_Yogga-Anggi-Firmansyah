package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductsComment;

public class GetProductsCommentSteps {

    @Steps
    GetProductsComment getProductsComment;

    @Given("user set API get all comment product")
    public void setAPIGetCommentProduct(){
        getProductsComment.setAPICommentProduct();
    }

    @When("user send request to get comment product")
    public void requestGetCommentProduct() {
        getProductsComment.requestCommentProduct();
    }

    @Then("user receive an information of commented product")
    public void receiveCommentedProduct() {
        getProductsComment.receiveCommentedProduct();
    }
}
