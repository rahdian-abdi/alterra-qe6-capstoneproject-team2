package starter.dummyjson.API.ProductsAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAllProductsApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String GET_ALL_PRODUCTS = URL+"/{parameter}";

    @Step("Get list all products")
    public void getAllProducts(String parameter) {
        SerenityRest.given().pathParam("parameter", parameter);
    }
}
