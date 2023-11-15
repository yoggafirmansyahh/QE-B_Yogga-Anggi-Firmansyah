package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.*;

public class CreateACategory {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API to create a category")
    public String setAPICreateCategory() {
        return url + "categories";
    }

    @Step("user send request to create a category")
    public void requestCreateCategory() {
        JSONObject requestBody = new JSONObject();


        requestBody.put("name","gaming");
        requestBody.put("description","for gaming purposes");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPICreateCategory());
    }

    @Step("user receive status code for create a category")
    public void receiveStatusCodeCreateCategory() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("category was created")
    public void categoryCreated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_A_CATEGORY_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
