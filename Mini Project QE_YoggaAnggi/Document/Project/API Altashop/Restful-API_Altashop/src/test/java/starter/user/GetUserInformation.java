package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetUserInformation {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API get user information")
    public String setAPIGetUserInformation() {
        return url + "auth/info";
    }

    @Step("user send request to get user information")
    public void requestGetUserInformation() {
        JSONObject requestBody = new JSONObject();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .get(setAPIGetUserInformation());
    }

    @Step("user receive status code 200 for get user information")
    public void receiveStatusCodeGetUserInformation() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive an information of user")
    public void receiveUserInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_INFORMATION_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Password'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
