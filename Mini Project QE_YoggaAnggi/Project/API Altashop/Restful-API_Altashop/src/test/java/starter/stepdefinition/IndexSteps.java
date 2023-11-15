package starter.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Index;

public class IndexSteps {

    @Steps
    Index index;

    @Given("user set API get index")
    public void setAPIIndex() {
        index.setAPIIndex();
    }

    @When("user send request to get index")
    public void requestIndex() {
        index.requestIndex();
    }

    @Then("user receive an hello feature")
    public void receiveHello() {
        index.receiveHello();
    }
}
