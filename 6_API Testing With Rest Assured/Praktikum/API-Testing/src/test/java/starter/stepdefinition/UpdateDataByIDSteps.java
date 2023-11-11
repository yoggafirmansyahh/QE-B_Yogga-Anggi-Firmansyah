package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.UpdateDataByID;

public class UpdateDataByIDSteps {

    @Steps
    UpdateDataByID updateDataByID;

    @Given("user memiliki akses ke API JSONPlaceholder untuk Update Data")
    public void setAPIEndpointUpdateData() {
        updateDataByID.setAPIEndpointUpdateData();
    }

    @When("user melakukan request PUT untuk Update Data")
    public void sendUpdateDataRequest() {
        updateDataByID.sendUpdateDataRequest();
    }

    @Then("user menerima respons dengan kode status 200 untuk Update Data")
    public void getResponseCode200UpdateData() {
        updateDataByID.getResponseCode200UpdateData();
    }

    @Given("user memiliki akses ke API JSONPlaceholder untuk Update Data secara invalid")
    public void setAPIEndpointInvalidUpdateDataByID() {
        updateDataByID.setAPIEndpointInvalidUpdateDataByID();
    }

    @When("user melakukan request PUT untuk Update Data secara invalid")
    public void sendPutRequestInvalidUpdateData() {
        updateDataByID.sendPutRequestInvalidUpdateData();
    }
    @Then("user harus menerima respons dengan kode status 404 untuk Update Data")
    public void getResponseCode404UpdateData() {
        updateDataByID.getResponseCode404UpdateData();
    }

    @And("update berhasil")
    public void updateSucces() {
        updateDataByID.updateSuccess();
    }

    @And("data gagal diupdate dan akan mendapat error message")
    public void updateFailedGetErrorMessage() {
        updateDataByID.updateFailedGetErrorMessage();
    }

}
