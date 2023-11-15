package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllCategories {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API get all categories")
    public String setAPIGetAllCategories() {
        return url + "categories";
    }

    @Step("user send request to get all categories")
    public void requestAllCategories() {

        SerenityRest.given()
                .get(setAPIGetAllCategories());
    }


    @Step("user receive an information of all categories")
    public void receiveAllCategories() {

        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
