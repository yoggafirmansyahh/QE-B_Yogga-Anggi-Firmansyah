package starter.user;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class DeleteData {

    private int validDataId = 1;
    private int invalidDataId = 9999;

    @Given("user memiliki akses ke API JSONPlaceholder untuk menghapus data")
    public void user_has_access_to_JSONPlaceholder_API_to_DeleteData() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/1";
    }

    @When("user melakukan request DELETE ke endpoint dengan ID yang valid")
    public void user_makes_DELETE_request_to_valid_endpoint() {
        deleteDataById(validDataId);
    }

    @When("user melakukan request DELETE ke endpoint dengan ID yang invalid")
    public void user_makes_DELETE_request_to_invalid_endpoint() {
        deleteDataById(invalidDataId);
    }

    @Then("user harus menerima respons dengan kode status 200 apabila valid {int}")
    public void user_should_receive_response_with_status_code_200(int statusCode) {
        verifyStatusCode(statusCode);
    }

    @Then("user harus menerima respons dengan kode status 404 apabila invalid {int}")
    public void user_should_receive_response_with_status_code_404(int statusCode) {
        verifyStatusCode(statusCode);
    }

    @Then("data dengan ID yang sesuai harus telah dihapus")
    public void data_with_matching_ID_should_have_been_deleted() {
        verifyDataDeleted();
    }

    @Step
    private void deleteDataById(int dataId) {
        given()
                .when()
                .delete("/data/" + dataId);
    }

    @Step
    private void verifyStatusCode(int expectedStatusCode) {
        given()
                .when()
                .then()
                .statusCode(expectedStatusCode);
    }

    @Step
    private void verifyDataDeleted() {
        // Implementasi pengujian apakah data dengan ID yang sesuai telah dihapus
    }
}
