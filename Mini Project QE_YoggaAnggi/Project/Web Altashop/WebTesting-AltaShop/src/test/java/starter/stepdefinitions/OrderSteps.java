package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.ProductPage;

public class OrderSteps {

    @Steps
    ProductPage productPage;

    @When("User click 'beli' button to add product on the order cart")
    public void addItemToOrderCart() {
        Assertions.assertTrue(productPage.beliButtonIsDisplayed());
        productPage.clickBeliButton() ;
    }

    @Then("Product is added to order cart")
    public void productIsAddedToOrder() {
        Assertions.assertTrue(productPage.validateCartCounterIsDisplayed());
        Assertions.assertTrue(productPage.validateCartCounter());
    }
}
