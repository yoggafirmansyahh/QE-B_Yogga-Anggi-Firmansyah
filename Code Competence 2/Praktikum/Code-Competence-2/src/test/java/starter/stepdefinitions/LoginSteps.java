package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Login;

public class LoginSteps {

    @Steps
    Login login;

    @Given("user send request untuk login dengan valid")
    public void setAPIEndpointLogin() {
        login.setAPIEndpointLogin();
    }

    @When("user send request dengan method POST untuk dapat login")
    public void sendLoginRequestValid() {
        login.sendLoginRequestValid();
    }

    @Then("muncul status code sesuai untuk login berhasil yaitu 200")
    public void receiveStatusCode200ValidLogin() {
        login.receiveStatusCode200ValidLogin();
    }

    @And("user telah login dengan valid")
    public void loginSuccess() {
        login.loginSuccess();
    }

    @Given("user send request untuk login dengan endpoint yang salah")
    public void setAPIInvalidLogin() {
        login.setAPIInvalidLogin();
    }

    @When("user send request dengan method POST dengan endpoint yang salah")
    public void sendLoginInvalidRequest() {
        login.sendLoginInvalidRequest();
    }

    @Then("muncul status code 400 yang menandakan error")
    public void receiveStatusCode400InvalidLogin() {
        login.receiveStatusCode400InvalidLogin();
    }

    @And("user gagal login dengan valid dan muncul pesan error")
    public void loginFailed() {
        login.loginFailed();
    }
}
