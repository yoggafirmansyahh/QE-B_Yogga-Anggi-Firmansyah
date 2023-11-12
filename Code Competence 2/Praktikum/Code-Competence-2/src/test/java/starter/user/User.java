package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class User {

private static String url = "https://fakestoreapi.com/users/";

    @Step("user akses endpoint untuk mendapatkan data user")
    public String setAPIGetSingleUser() {
        return url + "1";
    }

    @Step("user send request untuk mendapatkan satu data user")
    public void sendRequestGetSingleUser() {
        SerenityRest.given()
                .get(setAPIGetSingleUser());
    }

    @Step("data salah satu user dapat dilihat")
    public void getSingleUSerInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_SINGLE_USER_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body("'email'", notNullValue()));
        restAssuredThat(response -> response.body("'username'", notNullValue()));
        restAssuredThat(response -> response.body("'password'", notNullValue()));
        restAssuredThat(response -> response.body("'name'.'firstname'", notNullValue()));
        restAssuredThat(response -> response.body("'name'.'lastname'", notNullValue()));
        restAssuredThat(response -> response.body("'address'.'city'", notNullValue()));
        restAssuredThat(response -> response.body("'address'.'street'", notNullValue()));
        restAssuredThat(response -> response.body("'address'.'zipcode'", notNullValue()));
        restAssuredThat(response -> response.body("'address'.'geolocation'.'lat'", notNullValue()));
        restAssuredThat(response -> response.body("'address'.'geolocation'.'long'", notNullValue()));
        restAssuredThat(response -> response.body("'phone'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("user akses endpoint untuk menghapus data user")
    public String setAPIDeleteUser() {
        return url + "6";
    }

    @Step("user send request dengan method DELETE untuk menghapus data pada database")
    public void sendRequestDeleteUser() {
        SerenityRest.given()
                .delete(setAPIDeleteUser());
    }

    @Step("muncul status code sesuai yaitu 200 setelah mencoba menghapus data user")
    public void receiveStatusCodeDeleteUser() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
