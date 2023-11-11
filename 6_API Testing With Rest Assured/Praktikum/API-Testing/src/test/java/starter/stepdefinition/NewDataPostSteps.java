package starter.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.NewDataPost;

public class NewDataPostSteps {

    @Steps
    NewDataPost newDataPost;

    @Given("user memiliki akses ke API JSONPlaceholder untuk New Data Post")
    public void setAPIEndpointNewDataPost() {
        newDataPost.setAPIEndpointNewDataPost();
    }

    @Given("user memiliki akses ke API JSONPlaceholder untuk New Data Post dengan invalid")
    public void setAPIEndpointInvalidNewData() {
        newDataPost.setAPIEndpointInvalidNewData();
    }

    @When("user melakukan request POST untuk New Data Post")
    public void getPostMethodNewDataPost() {
        newDataPost.getPostMethodNewDataPost();
    }

    @When("user melakukan request POST untuk New Data Post dengan invalid")
    public void getInvalidNewDataPost() {
        newDataPost.getInvalidNewDataPost();
    }

    @Then("user harus menerima respons dengan kode status 201 untuk New Data Post")
    public void receiveResponseCode201NewDataPost (){
        newDataPost.receiveResponseCode201NewDataPost();
    }

    @Then("user harus menerima respons dengan kode status 500 untuk New Data Post")
    public void receiveResponseCode500NewDataPost (){
        newDataPost.receiveResponseCode500NewDataPost();
    }

    @And("respons berisi data baru")
    public void newDataCreated() {
        newDataPost.newDataCreated();
    }

    @And("data post baru gagal dibuat")
    public void newDataFailed() {
        newDataPost.newDataFailed();
    }
}
