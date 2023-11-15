package starter.user;

import com.github.javafaker.Faker;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.FileUtils;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.*;

public class Register {
    private static final String url = "https://altashop-api.fly.dev/api/auth/";

    @Step("user set API Endpoint to register page")
    public String setAPIEndpointRegister() {
        return url + "register";
    }

    @Step("user send request with a valid email and password to register")
    public void sendRequestValidRegister() {
        Faker faker = new Faker();
        JSONObject requestBody = new JSONObject();

        String email = faker.name().firstName();
        String name = faker.name().fullName();

        requestBody.put("email", email + "@mail.com");
        requestBody.put("password","123123");
        requestBody.put("fullname", name);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAPIEndpointRegister());

    }

    @Step("user send request with registered email and password to register")
    public void sendRequestInvalidRegister() {
        JSONObject requestBody = FileUtils.getUser();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("register success")
    public void registerSuccess() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Fullname'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Email'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Password'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("register failed and get error message")
    public void getErrorMessageRegister() {
        restAssuredThat(response -> response.statusCode(400));
    }
}