package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;


public class CreateNewOrder {
private static final String url = "https://altashop-api.fly.dev/api/";
    @Step("user set API to create new order")
    public String setAPIEndpointCreateOrder() {
        return url + "orders";
    }
    @Step("user send request to create new order")
    public void requestCreateNewOrder() {
        JSONObject requestBody = new JSONObject();
        JSONArray order  = new JSONArray();

        requestBody.put("product_id",85525);
        requestBody.put("quantity",1);
        order.put(0, requestBody);
        String data = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + data)
                .body(order.toString())
                .post(setAPIEndpointCreateOrder());
    }

    @Step("new order was created")
    public void newOrderCreated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ORDER_RESPONSE_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
