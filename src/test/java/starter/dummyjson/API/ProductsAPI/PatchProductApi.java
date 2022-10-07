package starter.dummyjson.API.ProductsAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class PatchProductApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String PATCH_PARAMETER = URL+"/products/{id}";

    @Step("Patch update product")
    public void patchUpdateProduct(int id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
