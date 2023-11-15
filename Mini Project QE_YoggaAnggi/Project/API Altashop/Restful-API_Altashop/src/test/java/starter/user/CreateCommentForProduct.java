package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

public class CreateCommentForProduct {

    @Step("user set API to comment for product")
    public String setAPICommentProduct() {
        String url = "https://altashop-api.fly.dev/api/products/";
        return url + "2/comments";
    }
    @Step("user send request to comment product")
    public void requestCommentProduct() {
        JSONObject requestbody = new JSONObject();
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        requestbody.put("content","the games are great including Gran Turismo 7 but sadly GT4 is much better");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestbody.toString())
                .post(setAPICommentProduct());
    }


    @Step("product has commented")
    public void productComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMMENT_FOR_PRODUCT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Content'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'User'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'Product'", nullValue()));
        restAssuredThat(response -> response.body("'data'.'Comment'", nullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
