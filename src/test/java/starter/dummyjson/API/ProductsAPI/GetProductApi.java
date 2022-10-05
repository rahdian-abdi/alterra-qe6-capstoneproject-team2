package starter.dummyjson.API.ProductsAPI;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetProductApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String GET_SINGLE_PRODUCT = URL+"/products/{id}";

    @Step("Get single product with id")
    public void getSingleProductWithId(int id) {
        SerenityRest.given().pathParam("id", id);
    }
}
