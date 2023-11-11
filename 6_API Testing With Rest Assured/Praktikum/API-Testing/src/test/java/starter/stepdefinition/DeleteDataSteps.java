package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteData;

public class DeleteDataSteps {

    @Steps
    DeleteData deleteData;

    @Given("user memiliki akses ke API JSONPlaceholder untuk hapus data")
    public void setAPIEndpointDeleteData() {
        deleteData.setAPIEndpointDeleteData();
    }
    @Given("user memiliki akses ke API JSONPlaceholder untuk hapus data dengan invalid")
    public void setAPIEndpointDeleteDataInvalid() {
        deleteData.setAPIEndpointDeleteDataInvalid();
    }

    @When("user melakukan request DELETE untuk hapus data")
    public void sendDeleteMethod() {
        deleteData.sendDeleteMethod();
    }

    @When("user melakukan request DELETE untuk hapus data dengan invalid")
    public void sendInvalidDeleteMethod() {
        deleteData.sendInvalidDeleteMethod();
    }

    @Then("user harus menerima respons dengan kode status 204 untuk hapus data")
    public void receiveStatusCode204DeleteData() {
        deleteData.receiveStatusCode204DeleteData();
    }

    @Then("user harus menerima respons dengan kode status 404 untuk hapus data")
    public void receiveStatusCode404DeleteData() {
        deleteData.receiveStatusCode404DeleteData();
    }

    @And("user mendapat pesan error untuk delete data")
    public void getDeleteErrorMessage() {
        deleteData.getDeleteErrorMessage();
    }
}
