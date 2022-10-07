package starter.dummyjson.API.UsersAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class UpdateUserPatchApi {
    public static String URl = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static String UPDATE_USER_PATCH_REGISTERED = URl + "/users/1";
    public static String UPDATE_USER_PATCH_UNREGISTERED = URl + "/users/103";
    public static String UPDATE_USER_PATCH_BODY_REQUEST = DIR +"/src/test/resources/JSON/BodyRequest/Users";
    public static String UPDATE_USER_PATCH_JSON_SCHEMA = DIR +"/src/test/resources/JSON/SchemaValidator/Users";




    @Step("Update user patch")
    public void updateuserPatch (File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json); }
}
