package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class GetDatabyID {
    private static String url = "https://jsonplaceholder.typicode.com/posts/";

    @Step("user memiliki akses ke API JSONPlaceholder untuk Get Data by ID")
    public String setApiEndpointGetDatabyID() {
        return url + "1";
    }

    @Step("user melakukan request GET ke posts untuk Get Data by ID")
    public void sendGetRequestGetDataByID() {
        SerenityRest.given()
                .get(setApiEndpointGetDatabyID());
    }

    @Step("user harus menerima respons dengan kode status 200 untuk Get Data by ID")
    public void getResponse200GetDataByID() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user memiliki akses ke API JSONPlaceholder untuk Get Data by ID secara invalid")
    public String setAPIEndpointGetDatabyIDInvalid() {
        return url + "319813";
    }

    @Step("user melakukan request GET ke posts untuk Get Data by ID secara invalid")
    public void sendRequestInvalidGetDatabyID() {
        SerenityRest.given()
                .get(setAPIEndpointGetDatabyIDInvalid());
    }
    @Step("user harus menerima respons dengan kode status 404 untuk Get Data by ID")
    public void getResponse404GetDataByID() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("respons harus berisi daftar postingan user sesuai ID")
    public void getDatabyIDSuccess() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_DATA_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'userId'", notNullValue()));
        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body("'title'", notNullValue()));
        restAssuredThat(response -> response.body("'body'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("user akan menerima pesan error untuk data id yang tidak muncul")
    public void getErrorMessageGetDatabyID() {
    }
}
