package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("user set API Endpoint to login")
    public void setAPIEndpointLogin() {
        login.setAPIEndpointLogin();
    }

    @When("user send request a valid email and password to login")
    public void sendLoginRequestValid() {
        login.sendLoginrequestValid();
    }

    @When("user send request an invalid email and valid password for login")
    public void requestInvalidEmailLogin() {
        login.requestInvalidEmailLogin();
    }


    @And("login success and get response 200 for login valid")
    public void receiveStatusCode200Login() {
        login.receiveStatusCode200Login();
    }

    @And("login failed and will get error message with status code 400 'wrong email'")
    public void receiveStatusCode400LoginEmail() {
        login.receiveStatusCode400LoginEmail();
    }
}
