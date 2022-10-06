package starter.dummyjson.API.ProductsAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteProductApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String DELETE_PRODUCT = URL+"/products/{id}";
    public static String DELETE_PRODUCT_INVALID = URL+"/products/{id}";

    @Step("Delete product with id")
    public void deleteProduct(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Delete product with invalid id")
    public void deleteProductInvalidId(String id) {
        SerenityRest.given().pathParam("id", id);
    }
}
