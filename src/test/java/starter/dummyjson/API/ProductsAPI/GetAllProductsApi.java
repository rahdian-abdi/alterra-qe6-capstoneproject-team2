package starter.dummyjson.API.ProductsAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAllProductsApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String GET_ALL_PRODUCTS = URL+"/{parameter}";
    public static String GET_ALL_PRODUCTS_WITH_KEYWORD = URL+"/products/search?q={keyword}";
    public static String GET_ALL_CATEGORIES = URL+"/products/{parameter}";
    public static String GET_ALL_PRODUCTS_BY_CATEGORY = URL+"/products/category/{parameter}";

    @Step("Get list all products")
    public void getAllProducts(String parameter) {
        SerenityRest.given().pathParam("parameter", parameter);
    }
    @Step("Get all products with keyword")
    public void getAllProductsWithKeyword(String keyword) {
        SerenityRest.given().pathParam("keyword", keyword);
    }
    @Step("Get all products categories")
    public void getAllProductsCategories(String parameter) {
        SerenityRest.given().pathParam("parameter", parameter);
    }
}
