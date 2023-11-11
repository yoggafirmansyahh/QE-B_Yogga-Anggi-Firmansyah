package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.*;

public class UpdateDataByID {

    private static String url = "https://jsonplaceholder.typicode.com/posts/1";


    @Step("user memiliki akses ke API JSONPlaceholder untuk Update Data")
    public String setAPIEndpointUpdateData() {
        return url + "1";
    }
    @Step("user melakukan request PUT untuk Update Data")
    public void sendUpdateDataRequest() {
        SerenityRest.given()
                .put(setAPIEndpointUpdateData());
    }
    @Step("user menerima respons dengan kode status 200 untuk Update Data")
    public void getResponseCode200UpdateData() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("update berhasil")
    public void updateSuccess() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_DATA_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'id'", equalTo(1)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("user memiliki akses ke API JSONPlaceholder untuk Update Data secara invalid")
    public String setAPIEndpointInvalidUpdateDataByID() {
        return url + "319813";
    }

    @Step("user melakukan request PUT untuk Update Data secara invalid")
    public void sendPutRequestInvalidUpdateData() {
        SerenityRest.given()
                .put(setAPIEndpointInvalidUpdateDataByID());
    }
    @Step("user harus menerima respons dengan kode status 500 untuk Update Data")
    public void getResponseCode404UpdateData() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("data gagal diupdate")
    public void updateFailedGetErrorMessage() {
    }
}

