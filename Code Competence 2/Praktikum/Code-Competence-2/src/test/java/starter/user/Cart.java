package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Cart {
    private static String url = "https://fakestoreapi.com/carts";

    @Step("user memiliki akses untuk dapat melakukan penghapusan produk pada cart")
    public String setAPIEndpointDeleteProductCart() {
        return url + "6";
    }

    @Step("user send request dengan method DELETE untuk menghapus data")
    public void requestDeleteMethodCart() {
        SerenityRest.given()
                .delete(setAPIEndpointDeleteProductCart());
    }

    @Step("user berhasil melakukan delete pada data di dalam cart")
    public void deleteOnCartSuccess() {
    }
}
