package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Product {


    private static String url = "https://fakestoreapi.com/";

    @Step("user akses endpoint untuk mengakses informasi produk dengan valid")
    public String setAPIEndpointGetAllProducts() {
        return url + "products";
    }

    @Step("user send request dengan endpoint yang valid untuk mengakses informasi produk")
    public void sendRequestGetAllProducts() {
        SerenityRest.given()
                .get(setAPIEndpointGetAllProducts());
    }

    @Step("muncul status code sesuai untuk menampilkan semua informasi produk")
    public void receiveStatusCodeGetAllProducts() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("semua informasi produk berhasil ditampikan")
    public void getAllProductsInformation() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("user akses endpoint untuk dapat melakukan penghapusan produk pada database")
    public String setAPIEndpointDeleteProduct() {
        return url + "products/6";
    }

    @Step("user send request dengan method DELETE untuk menghapus data dengan endpoint yang benar")
    public void sendRequestDeleteProduct() {
        SerenityRest.given()
                .delete(setAPIEndpointDeleteProduct());
    }

    @Step("muncul status code sesuai setelah menghapus data informasi produk")
    public void receiveStatusCodeDeleteProduct() {
        restAssuredThat(response -> response.statusCode(200));
    }
}

