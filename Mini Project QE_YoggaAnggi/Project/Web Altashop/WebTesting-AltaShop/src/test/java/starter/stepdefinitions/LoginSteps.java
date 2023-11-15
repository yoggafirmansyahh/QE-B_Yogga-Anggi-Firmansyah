package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.LoginPage;
import starter.pages.ProductPage;

public class LoginSteps {

    @Steps
    LoginPage loginPage;
    @Steps
    ProductPage productPage;

    @Given("User is on the login page")
    public void onTheLoginPage() {
        loginPage.openUrl("https://alta-shop.vercel.app/login");
        Assertions.assertTrue(loginPage.validateOnLoginPage());
    }

    @When("User input an email")
    public void inputValidEmail() {
        loginPage.inputValidEmail("yoggafirmansyah94@gmail.com");

    }

    @And("User input a password")
    public void inputValidPassword() {
        loginPage.inputPassword("yoggafirmansyah99");
    }

    @And("User click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User is on the product page")
    public void onTheProductPage() {
        Assertions.assertTrue(productPage.validateOnProductPage());
    }
}
