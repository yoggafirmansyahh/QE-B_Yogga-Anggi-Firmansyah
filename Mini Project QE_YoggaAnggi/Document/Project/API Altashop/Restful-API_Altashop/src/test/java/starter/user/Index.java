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

public class Index {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API get index")
    public String setAPIIndex() {
        return url + "hello";
    }

    @Step("user send request to get index")
    public void requestIndex() {
        JSONObject requestBody = new JSONObject();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .get(setAPIIndex());
    }

    @Step("user receive an hello feature")
    public void receiveHello() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INDEX_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
