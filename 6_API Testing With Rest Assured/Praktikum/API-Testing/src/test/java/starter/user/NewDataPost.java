package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class NewDataPost {
    private static String url = "https://jsonplaceholder.typicode.com/";


    @Step("user memiliki akses ke API JSONPlaceholder untuk New Data Post")
    public String setAPIEndpointNewDataPost() {
        return url + "posts";
    }
    @Step("user melakukan request POST untuk New Data Post")
    public void getPostMethodNewDataPost() {
        SerenityRest.given()
                .post(setAPIEndpointNewDataPost());
    }

    @Step("user harus menerima respons dengan kode status 201 untuk New Data Post")
    public void receiveResponseCode201NewDataPost() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("respons berisi data baru")
    public void newDataCreated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.NEW_DATA_POST_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("user memiliki akses ke API JSONPlaceholder untuk New Data Post dengan invalid")
    public String setAPIEndpointInvalidNewData() {
        return url;
    }

    @Step("user melakukan request POST untuk New Data Post dengan invalid")
    public void getInvalidNewDataPost() {
        SerenityRest.given()
                .post(setAPIEndpointInvalidNewData());
    }
    @Step("user harus menerima respons dengan kode status 500 untuk New Data Post")
    public void receiveResponseCode500NewDataPost() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("data post baru gagal dibuat")
    public void newDataFailed() {
    }




}
