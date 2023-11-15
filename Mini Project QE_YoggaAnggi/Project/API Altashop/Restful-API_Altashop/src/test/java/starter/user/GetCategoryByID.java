package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.*;

public class GetCategoryByID {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API get category by ID")
    public String setAPIGetCategoryById() {
        return url + "categories/30104";
    }

    @Step("user send request to get category by ID")
    public void requestGetCategoryById() {
        JSONObject requestBody = new JSONObject();

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .get(setAPIGetCategoryById());
    }

    @Step("user receive status code for get category by ID")
    public void receiveStatusCodeGetCategoryById() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user receive an information of category based on ID")
    public void receiveCategoryById() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", equalTo(30104)));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
