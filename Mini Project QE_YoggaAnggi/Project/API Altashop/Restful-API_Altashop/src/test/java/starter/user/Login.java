package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class Login {
    private static final String API_URL = "https://altashop-api.fly.dev/api/auth/";

    @Step("user set API Endpoint to login")
    public String setAPIEndpointLogin() {
        return API_URL + "login";
    }

    @Step("user send request a valid email and password to login")
    public void sendLoginrequestValid() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        try {
            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .body(requestBody.toString())
                    .post(setAPIEndpointLogin());
        } catch (Exception e) {
            // Handle exception here
            e.printStackTrace();
        }
    }

    @Step("user send request an invalid email and valid password for login")
    public void requestInvalidEmailLogin() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someeonee@mail.com");
        requestBody.put("password", "123123");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        try {
            SerenityRest.given()
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token)
                    .body(requestBody.toString())
                    .post(setAPIEndpointLogin());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Step("login success and get response 200 for login valid")
    public void receiveStatusCode200Login() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("login failed and will get error message with status code 400 (wrong email)")
    public void receiveStatusCode400LoginEmail() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
