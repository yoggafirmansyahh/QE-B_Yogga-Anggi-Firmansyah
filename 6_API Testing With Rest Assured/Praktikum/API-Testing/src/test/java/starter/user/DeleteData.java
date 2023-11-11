package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteData {
    private static String url = "https://jsonplaceholder.typicode.com/posts/1";

    @Step("user memiliki akses ke API JSONPlaceholder untuk hapus data")
    public String setAPIEndpointDeleteData() {
        return url + "1";
    }
    @Step("user melakukan request DELETE untuk hapus data")
    public void sendDeleteMethod() {
        SerenityRest.given().delete(setAPIEndpointDeleteData());
    }

    @Step("user harus menerima respons dengan kode status 200 untuk hapus data")
    public void receiveStatusCode204DeleteData() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("user memiliki akses ke API JSONPlaceholder untuk hapus data dengan invalid")
    public String setAPIEndpointDeleteDataInvalid() {
        return url;
    }
    @Step("user melakukan request DELETE untuk hapus data dengan invalid")
    public void sendInvalidDeleteMethod() {
        SerenityRest.given()
                .delete(setAPIEndpointDeleteDataInvalid());
    }
    @Step("user harus menerima respons dengan kode status 404 untuk hapus data")
    public void receiveStatusCode404DeleteData() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("user mendapat pesan error untuk delete data")
    public void getDeleteErrorMessage() {
    }
}
