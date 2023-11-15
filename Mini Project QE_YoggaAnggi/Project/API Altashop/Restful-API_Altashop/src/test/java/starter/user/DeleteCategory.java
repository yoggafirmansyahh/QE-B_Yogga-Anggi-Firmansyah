package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategory {
    private static String url = "https://altashop-api.fly.dev/api/";

    @Step("user set API delete category")
    public String setAPIDeleteCategory() {
        return url + "categories/1";
    }

    @Step("user send request to delete category")
    public void requestDeleteCategory() {
        JSONObject requestBody = new JSONObject();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .delete(setAPIDeleteCategory());
    }

    @Step("user receive status code for deleted category")
    public void receiveStatusCodeDeleteCategory() {
        restAssuredThat(response -> response.statusCode(200));
    }
}
