package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteCategory;

public class DeleteCategorySteps {

    @Steps
    DeleteCategory deleteCategory;

    @Given("user set API delete category")
    public void setAPIDeleteCategory() {
        deleteCategory.setAPIDeleteCategory();
    }

    @When("user send request to delete category")
    public void requestDeleteCategory() {
        deleteCategory.requestDeleteCategory();
    }

    @Then("user receive status code for deleted category")
    public void receiveStatusCodeDeleteCategory() {
        deleteCategory.receiveStatusCodeDeleteCategory();
    }
}
