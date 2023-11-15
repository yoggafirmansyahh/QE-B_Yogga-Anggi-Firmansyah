package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetProductRating;

public class GetProductRatingSteps {

    @Steps
    GetProductRating getProductRating;

    @Given("user set API get product rating")
    public void setAPIGetProductRating(){
        getProductRating.setAPIGetProductRating();
    }

    @When("user send request to get product rating")
    public void requestGetProductRating() {
        getProductRating.requestGetProductRating();
    }

    @Then("user receive a rating information of product")
    public void receiveProductRating() {
        getProductRating.receiveProductRating();
    }
}
