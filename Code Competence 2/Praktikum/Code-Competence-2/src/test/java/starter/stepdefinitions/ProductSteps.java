package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.Product;

public class ProductSteps {

    @Steps
    Product product;

    @Given("user akses endpoint untuk mengakses informasi produk dengan valid")
    public void setAPIEndpointGetAllProducts(){
        product.setAPIEndpointGetAllProducts();
    }

    @When("user send request dengan endpoint yang valid untuk mengakses informasi produk")
    public void sendRequestGetAllProducts() {
        product.sendRequestGetAllProducts();
    }

    @Then("muncul status code sesuai untuk menampilkan semua informasi produk")
    public void receiveStatusCodeGetAllProducts() {
        product.receiveStatusCodeGetAllProducts();
    }

    @And("semua informasi produk berhasil ditampikan")
    public void getAllProductsInformation(){
        product.getAllProductsInformation();
    }


    @Given("user akses endpoint untuk dapat melakukan penghapusan produk pada database")
    public void setAPIEndpointDeleteProduct() {
        product.setAPIEndpointDeleteProduct();
    }

    @When("user send request dengan method DELETE untuk menghapus data dengan endpoint yang benar")
    public void sendRequestDeleteProduct() {
        product.sendRequestDeleteProduct();
    }

    @Then("muncul status code sesuai setelah menghapus data informasi produk")
    public void receiveStatusCodeDeleteProduct() {
        product.receiveStatusCodeDeleteProduct();
    }
}
