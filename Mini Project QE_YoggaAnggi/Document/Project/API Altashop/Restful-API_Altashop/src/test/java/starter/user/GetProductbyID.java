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

public class GetProductbyID {
    private static final String url = "https://altashop-api.fly.dev/api/products/";

    @Step("user set API get product by ID")
    public String setAPIEndpointGetProductbyID() {
        return url + "85531";
    }

    @Step("user send request to get product by ID")
    public void sendGetProductByIdRequest() {
        JSONObject requestBody = new JSONObject();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        requestBody.put("name","Sony PS5");
        requestBody.put("description","play has no limits");
        requestBody.put("price","299");
        requestBody.put("categories","1");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .get(setAPIEndpointGetProductbyID());
    }

    @Step("user receive status code 200 for get user by ID")
    public void receiveStatusCode200GetProductByID() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive an information of product based on ID")
    public void receiveProductByID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Price'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Ratings'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
