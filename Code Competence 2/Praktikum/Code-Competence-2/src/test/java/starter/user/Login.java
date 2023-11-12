package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class Login {

    private static String url = "https://fakestoreapi.com/auth/";

    @Step("user send request untuk login dengan valid")
    public String setAPIEndpointLogin() {
        return url + "login";
    }

    @Step("user send request dengan method POST untuk dapat login")
    public void sendLoginRequestValid() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "mor_2314");
        requestBody.put("password", "83r5^_");

        SerenityRest.given()
                .post(setAPIEndpointLogin());
    }

    @Step("muncul status code sesuai untuk login berhasil yaitu 200")
    public void receiveStatusCode200ValidLogin() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_RESPONSE_SCHEMA);
        restAssuredThat(response -> response.body("'token'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("user telah login dengan valid")
    public void loginSuccess() {
    }

    @Step("user send request untuk login dengan endpoint yang")
    public String setAPIInvalidLogin() {
        return url + "loggin";
    }

    @Step("user send request dengan method POST dengan endpoint yang salah")
    public void sendLoginInvalidRequest() {
        SerenityRest.given()
                .post(setAPIEndpointLogin());
    }

    @Step("muncul status code 400 yang menandakan error")
    public void receiveStatusCode400InvalidLogin() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("user gagal login dengan valid dan muncul pesan error")
    public void loginFailed() {
    }
}
