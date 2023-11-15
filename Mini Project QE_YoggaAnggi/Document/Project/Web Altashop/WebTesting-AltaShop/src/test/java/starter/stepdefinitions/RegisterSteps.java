package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.LoginPage;
import starter.pages.RegisterPage;

public class RegisterSteps {

    @Steps
    RegisterPage registerPage;

    @Steps
    LoginPage loginPage;

    @Given("User is on the register page")
    public void onTheRegisterPage() {
        registerPage.openUrl("https://alta-shop.vercel.app/auth/register");
        registerPage.validateOnRegisterPage();
    }

    @When("User input an username for register")
    public void inputUsernameRegister() {
        registerPage.inputUsernameRegister("username");
    }

    @And("User input an email for register")
    public void inputEmailRegister() {
        registerPage.inputEmailRegister("yoggafirmansyah94@gmail.com");
    }

    @And("User input a password for register")
    public void inputPasswordRegister() {
        registerPage.inputPasswordRegister("blablalba");
    }

    @And("User click register button")
    public void clickRegisterButton() {
        registerPage.clickRegisterButton();
    }
    @Then("Register success and user is on the login page")
    public void onTheLoginPage() {
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }
}
