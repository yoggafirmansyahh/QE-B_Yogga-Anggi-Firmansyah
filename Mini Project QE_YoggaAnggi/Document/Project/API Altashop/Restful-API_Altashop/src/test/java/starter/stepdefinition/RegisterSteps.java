package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Register;

public class RegisterSteps {

    @Steps
    Register register;

    @Given("user set API Endpoint to register page")
    public void setAPIEndpointRegister() {
        register.setAPIEndpointRegister();
    }

    @When("user send request with a valid email and password to register")
    public void sendRequestValidRegister() {
        register.sendRequestValidRegister();
    }

    @When("user send request with registered email and password to register")
    public void sendRequestInvalidRegister() {
        register.sendRequestInvalidRegister();
    }

    @And("register success")
    public void registerSuccess() {
        register.registerSuccess();
    }
    @And("register failed and get error message")
    public void getErrorMessageRegister() {
        register.getErrorMessageRegister();
    }

}
