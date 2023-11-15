package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;


public class CreateNewProduct {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API to create new product")
    public String setAPICreateProduct() {
        return url + "products";
    }

    @Step("user send request to create new product")
    public void requestCreateProduct() {
        JSONObject product = new JSONObject();
        JSONArray categories = new JSONArray();
        JSONObject data = new JSONObject();
        data.put("data", product);

        product.put("name", "Sony PS5");
        product.put("description", "play has no limits");
        product.put("price", 299);
        product.put("categories", categories);

        System.out.println(data.toString(1));
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(product.toString())
                .post(setAPICreateProduct());
    }

    @Step("new product was created")
    public void productCreated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PRODUCT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
