package starter.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateData {

    private int validDataId = 1;
    private int invalidDataId = 999999;

    @Given("user memiliki akses ke API JSONPlaceholder")
    public void user_has_access_to_JSONPlaceholder_API_to_UpdateData() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
    }

    @When("user melakukan request PUT ke endpoint dengan ID yang valid")
    public void user_makes_PUT_request_to_valid_endpoint_to_UpdateData() {
        updateDataById(validDataId);
    }

    @When("user melakukan request PUT ke endpoint dengan ID yang tidak valid")
    public void user_makes_PUT_request_to_invalid_endpoint_to_UpdateData() {
        updateDataById(invalidDataId);
    }

    @Then("user harus menerima respons dengan kode status untuk case valid pada Update Data {int}")
    public void user_should_receive_response_with_status_code_valid(int statusCode) {
        verifyStatusCode(200);
    }
    @Then("user harus menerima respons dengan kode status case invalid pada Update Data {int}")
    public void user_should_receive_response_with_status_code_invalid(int statusCode) {
        verifyStatusCode(404);
    }

    @Then("data dengan ID yang sesuai harus diperbarui")
    public void matching_data_should_be_updated() {
        verifyDataUpdated();
    }

    @Then("data dengan ID yang sesuai tidak boleh diperbarui")
    public void matching_data_should_not_be_updated() {
        verifyDataNotUpdated();
    }

    @Step
    private void updateDataById(int dataId) {
        given()
                .when()
                .put("/data/" + dataId);
    }

    @Step
    private void verifyStatusCode(int expectedStatusCode) {
    }

    @Step
    private void verifyDataUpdated() {
    }

    @Step
    private void verifyDataNotUpdated() {
    }
}

