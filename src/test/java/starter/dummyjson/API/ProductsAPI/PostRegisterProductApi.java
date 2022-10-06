package starter.dummyjson.API.ProductsAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class PostRegisterProductApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String POST_VALID_PARAMETER = URL+"/products/add";
    public static String POST_INVALID_PARAMETER = URL+"/products/addzzz";

    @Step("Post register product body request")
    public void postBodyRequest(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
