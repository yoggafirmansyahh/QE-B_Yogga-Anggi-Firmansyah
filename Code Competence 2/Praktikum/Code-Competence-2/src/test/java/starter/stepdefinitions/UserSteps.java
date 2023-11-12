package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.User;

public class UserSteps {

    @Steps
    User user;

    @Given("user akses endpoint untuk mendapatkan data user")
    public void setAPIGetSingleUser() {
        user.setAPIGetSingleUser();
    }

    @When("user send request untuk mendapatkan satu data user")
    public void sendRequestGetSingleUser() {
        user.sendRequestGetSingleUser();
    }

    @Then("data salah satu user dapat dilihat")
    public void getSingleUserInformation() {
        user.getSingleUSerInformation();
    }

    @Given("user akses endpoint untuk menghapus data user")
    public void setAPIDeleteUser() {
        user.setAPIDeleteUser();
    }

    @When("user send request dengan method DELETE untuk menghapus data pada database")
    public void sendRequestDeleteUser() {
        user.sendRequestDeleteUser();
    }

    @Then("muncul status code sesuai yaitu 200 setelah mencoba menghapus data user")
    public void receiveStatusCodeDeleteUser() {
        user.receiveStatusCodeDeleteUser();
    }
}
