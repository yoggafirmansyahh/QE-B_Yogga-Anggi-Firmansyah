package starter.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetDataPost {

    private int validPostId = 1;
    private int invalidPostId = 999999;

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get Data Post")
    public void user_access_to_JSONPlaceholder_API_to_GetDataPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    @When("user melakukan request GET ke endpoint dengan ID yang valid untuk mendapatkan data post")
    public void user_makes_GET_request_to_valid_endpoint_to_GetDataPost() {
        getDataPostById(validPostId);
    }

    @When("user melakukan request GET ke endpoint dengan ID yang tidak valid untuk mendapatkan data post")
    public void user_send_GET_request_to_invalid_endpoint_to_GetDataPost() {
        getDataPostById(invalidPostId);
    }

    @Then("user harus menerima respons dengan kode status untuk case valid {int}")
    public void user_should_receive_response_with_status_code_positif_case(int statusCode) {
        verifyStatusCode(200);
    }

    @Then("user harus menerima respons dengan kode status untuk case invalid {int}")
    public void user_should_receive_response_with_status_code_negatif_case(int statusCode) {
        verifyStatusCode(404);
    }

    @Then("data post dengan ID yang sesuai harus ditemukan")
    public void matching_data_should_be_found() {
        verifyDataPostFound();
    }

    @Then("tidak ada data post yang ditemukan")
    public void no_data_should_be_found() {
        verifyNoDataPostFound();
    }

    @Step
    private void getDataPostById(int postId) {
        given()
                .when()
                .get("/posts/" + postId);
    }

    @Step
    private void verifyStatusCode(int expectedStatusCode) {
    }

    @Step
    private void verifyDataPostFound() {
    }

    @Step
    private void verifyNoDataPostFound() {
    }
}
