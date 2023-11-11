package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetUser;

public class GetUserSteps {

    @Steps
    GetUser getUser;

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get User")
    public void setAPIEndointGetUser() {
        getUser.setAPIEndpointGetUser();
    }

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get User secara invalid")
    public void setAPIEndpointInvalidGetUser() {
        getUser.setAPIEndpointInvalidGetUser();
    }
    @When("user melakukan request GET untuk Get User")
    public void sendGetRequestValidID() {
        getUser.sendGetRequestValidID();
    }

    @When("user melakukan request GET ke endpoint dengan ID yang tidak valid untuk Get User")
    public void getRequestInvalidID() {
        getUser.getRequestInvalidID();
    }

    @Then("user harus menerima respons dengan kode status 200 untuk Get User")
    public void receiveStatusCode200GetUser() {
        getUser.receiveStatusCode200GetUser();
    }

    @Then("user harus menerima respons dengan kode status 404 untuk Get User")
    public void receiveStatusCode404GetUser() {
        getUser.receiveStatusCode404GetUser();
    }

    @And("data user berhasil didapatkan")
    public void receiveUserDataValid() {
        getUser.receiveUserDataValid();
    }
    @And("tidak ada data user yang ditemukan")
    public void dataNotFoundGetUser() {
        getUser.dataNotFoundGetUser();
    }

}
