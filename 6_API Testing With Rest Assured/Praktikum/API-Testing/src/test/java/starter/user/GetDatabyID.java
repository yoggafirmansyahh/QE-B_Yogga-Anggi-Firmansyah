package starter.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetDatabyID {

    private int validDataId = 1;
    private int invalidDataId = 999999;

    @Given("user memiliki akses ke API JSONPlaceholder untuk mendapatkan data dengan ID")
    public void user_access_to_JSONPlaceholder_API_to_GetDatabyID() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
    }

    @When("user melakukan request GET ke endpoint dengan ID yang valid untuk Get Data by ID")
    public void user_send_GET_request_to_valid_endpoint_to_GetDatabyID() {
        getDataById(validDataId);
    }

    @When("user melakukan request GET ke endpoint dengan ID yang tidak valid untuk Get Data by ID")
    public void user_melakukan_send_request_untuk_GetDatabyID() {
        getDataById(invalidDataId);
    }

    @Then("user harus menerima respons dengan kode status apabila valid {int}")
    public void user_should_receive_response_with_status_code_positifcase(int statusCode) {
        verifyStatusCode(200);
    }

    @Then("user harus menerima respons dengan kode status apabila invalid {int}")
    public void user_should_receive_response_with_status_code_negatifcase(int statusCode) {
        verifyStatusCode(404);
    }

    @Then("data dengan ID yang sesuai harus ditemukan")
    public void matching_data_should_be_found() {
        verifyDataFound();
    }

    @Then("tidak ada data yang ditemukan")
    public void no_data_should_be_found() {
        verifyNoDataFound();
    }

    @Step
    private void getDataById(int dataId) {
        given()
                .when()
                .get("/data/" + dataId);
    }

    @Step
    private void verifyStatusCode(int expectedStatusCode) {
    }

    @Step
    private void verifyDataFound() {
    }

    @Step
    private void verifyNoDataFound() {
    }
}
