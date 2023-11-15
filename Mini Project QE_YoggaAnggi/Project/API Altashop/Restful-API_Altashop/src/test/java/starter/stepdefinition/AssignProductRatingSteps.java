package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.AssignProductRating;

public class AssignProductRatingSteps {

    @Steps
    AssignProductRating assignProductRating;

    @Given("user set API to assign rating for product")
    public void setAPIAssignRating(){
        assignProductRating.setAPIAssignRating();
    }

    @When("user send request to assign rating")
    public void requestAssignProduct() {
        assignProductRating.requestAssignProduct();
    }

    @And("rating of product has assigned")
    public void ratingAssigned() {
        assignProductRating.ratingAssigned();
    }
}
