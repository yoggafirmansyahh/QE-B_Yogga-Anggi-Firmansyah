package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrders {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API get all orders")
    public String setAPIGetAllOrders() {
        return url + "orders";
    }

    @Step("user send request to get all orders")
    public void requestGetAllOrders() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6Ik1pYSBBcHJpbGlhIFNhdHlhIiwiRW1haWwiOiJtaWFhcHJpbGlhMjgwM0BnbWFpbC5jb20ifQ.TPBmPPvDadWplwIqkNwOsAqIY4hw6bk4zis8XxHQ_jk";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIGetAllOrders());
    }

    @Step("user receive an information of all orders")
    public void receiveAllOrders() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDERS_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
