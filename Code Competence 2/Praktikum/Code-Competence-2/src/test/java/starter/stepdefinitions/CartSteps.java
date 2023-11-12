package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Cart;

public class CartSteps {

    @Steps
    Cart cart;

    @Given("user memiliki akses untuk dapat melakukan penghapusan produk pada cart")
    public void setAPIEndpointDeleteProductCart() {
        cart.setAPIEndpointDeleteProductCart();
    }

    @When("user send request dengan method DELETE untuk menghapus data")
    public void requestDeleteMethodCart() {
        cart.requestDeleteMethodCart();
    }


    @And("user berhasil melakukan delete pada data di dalam cart")
    public void deleteOnCartSuccess() {
        cart.deleteOnCartSuccess();
    }
}
