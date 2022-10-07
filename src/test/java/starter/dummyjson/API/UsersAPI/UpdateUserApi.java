package starter.dummyjson.API.UsersAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class UpdateUserApi {

    public static String URl = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static String UPDATE_USER = URl + "/users/1";
    public static String UPDATE_USER_UNREGISTERED = URl + "/users/101";
    public static String UPDATE_USER_SPECIAL_CHARACTER = URl + "/users/@@@@";
    public static String UPDATE_USER_BODY_REQUEST = DIR +"/src/test/resources/JSON/BodyRequest/Users";
    public static String UPDATE_USER_JSON_SCHEMA = DIR +"/src/test/resources/JSON/SchemaValidator/Users";




    @Step("Set update body data")
    public void setUpdateBodyData (File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json); }






}
