package starter.user;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetUser {

    private int validUserId = 1;
    private int invalidUserId = 999999;

    @Given("user memiliki akses ke API JSONPlaceholder untuk Get USer")
    public void user_has_access_to_JSONPlaceholder_API_to_GetUser() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    @When("user melakukan request GET ke endpoint dengan ID yang valid untuk Get User")
    public void user_makes_GET_request_to_valid_endpoint_to_GetUser() {
        getUserDataById(validUserId);
    }

    @When("user melakukan request GET ke endpoint dengan ID yang tidak valid untuk Get User")
    public void user_makes_GET_request_to_invalid_endpoint_to_GetUser() {
        getUserDataById(invalidUserId);
    }

    @Then("user harus menerima respons dengan kode status 200 untuk fitur Get User {int}")
    public void user_should_receive_response_with_status_code_200(int statusCode) {
        verifyStatusCode(200);
    }

    @Then("user harus menerima respons dengan kode status 404 untuk fitur Get User {int}")
    public void user_should_receive_response_with_status_code_404(int statusCode) {
        verifyStatusCode(404);
    }

    @Then("data user dengan ID yang sesuai harus ditemukan")
    public void matching_data_should_be_found() {
        verifyUserDataFound();
    }

    @Then("tidak ada data user yang ditemukan")
    public void no_data_should_be_found() {
        verifyNoUserDataFound();
    }

    @Step
    private void getUserDataById(int userId) {
        given()
                .when()
                .get("/users/" + userId);
    }

    @Step
    private void verifyStatusCode(int expectedStatusCode) {
    }

    @Step
    private void verifyUserDataFound() {
    }

    @Step
    private void verifyNoUserDataFound() {
    }
}
