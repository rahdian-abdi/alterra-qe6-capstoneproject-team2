package starter.dummyjson.API.ProductsAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class PutUpdateProductApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String UPDATE_PARAMETER = URL+"/products/{id}";
    public static String UPDATE_INVALID_PARAMETER = URL+"/{parameter}/1";

    @Step("Put update product")
    public void putUpdateProduct(int id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update product invalid parameter")
    public void putUpdateProductInvalid(String parameter, File json) {
        SerenityRest.given().pathParam("parameter", parameter)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update product invalid id")
    public void putUpdateProductInvalidId(String id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
