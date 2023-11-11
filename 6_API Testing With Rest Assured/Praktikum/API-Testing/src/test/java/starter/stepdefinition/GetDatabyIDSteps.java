package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.GetDatabyID;

public class GetDatabyIDSteps {

    @Steps
    GetDatabyID getDatabyID;

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get Data by ID")
    public void setApiEndpointGetDatabyID() {
        getDatabyID.setApiEndpointGetDatabyID();
    }

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get Data by ID secara invalid")
    public void setAPIEndpointGetDatabyIDInvalid() {
        getDatabyID.setAPIEndpointGetDatabyIDInvalid();
    }

    @When("user melakukan request GET ke posts untuk Get Data by ID")
    public void sendGetRequestGetDataByID() {
        getDatabyID.sendGetRequestGetDataByID();
    }

    @When("user melakukan request GET ke posts untuk Get Data by ID secara invalid")
    public void sendRequestInvalidGetDatabyID() {
        getDatabyID.sendRequestInvalidGetDatabyID();
    }
    @Then("user harus menerima respons dengan kode status 200 untuk Get Data by ID")
    public void getResponse200GetDataByID(){
        getDatabyID.getResponse200GetDataByID();
    }

    @Then("user harus menerima respons dengan kode status 404 untuk Get Data by ID")
    public void getResponse404GetDataByID(){
        getDatabyID.getResponse404GetDataByID();
    }

    @And("respons harus berisi daftar postingan user sesuai ID")
    public void getDatabyIDSuccess() {
        getDatabyID.getDatabyIDSuccess();
    }

    @And("user akan menerima pesan error untuk data id yang tidak muncul")
    public void getErrorMessageGetDatabyID() {
        getDatabyID.getErrorMessageGetDatabyID();
    }
}

