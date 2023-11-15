package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;


import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {

    @Step("user set API delete product")
    public String setAPIEndpointDeleteProduct() {
        String url = "https://altashop-api.fly.dev/api/products/";
        return url + "2";
    }
    @Step("user send request to delete product")
    public void sendRequestDeleteProduct() {
        JSONObject requestBody = new JSONObject();

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .delete(setAPIEndpointDeleteProduct());
    }
    @Step("user receive status code for deleted product")
    public void receiveStatusCodeDeleteProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }


}
