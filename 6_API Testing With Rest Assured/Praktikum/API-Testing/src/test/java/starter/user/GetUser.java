package starter.user;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetUser {
    private static String url = "https://jsonplaceholder.typicode.com/";

    @Step("user memiliki akses ke API JSONPlaceholder")
    public String setAPIEndpointGetUser() {
        return url + "posts";
    }

    @Step("user melakukan request GET ke posts untuk Get User")
        public void sendGetRequestValidID() {
        SerenityRest.given().get(setAPIEndpointGetUser());
    }
    @Step("user harus menerima respons dengan kode status 200 untuk Get User")
    public void receiveStatusCode200GetUser() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("data user berhasil didapatkan")
    public void receiveUserDataValid() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_RESPONSE_SCHEMA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("user memiliki akses ke API JSONPlaceholder untuk Get User secara invalid")
    public String setAPIEndpointInvalidGetUser() {
        return url;
    }
    @Step("user melakukan request GET ke endpoint dengan ID yang tidak valid untuk Get User")
    public void getRequestInvalidID() {
        SerenityRest.given().get(setAPIEndpointGetUser());
    }
    @Step("user harus menerima respons dengan kode status 404 untuk Get User")
    public void receiveStatusCode404GetUser() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("tidak ada data user yang ditemukan")
    public void dataNotFoundGetUser() {
    }




}