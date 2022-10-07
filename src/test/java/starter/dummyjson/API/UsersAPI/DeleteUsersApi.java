package starter.dummyjson.API.UsersAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteUsersApi {
    public static String URl = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static String DELETE_USER_JSON_SCHEMA = DIR +"/src/test/resources/JSON/SchemaValidator/Users";
    public static String DELETE_USER = URl + "/users/{id}";





    @Step("Delete user")
    public void deleteUser (int id) {
        SerenityRest.given()
                .pathParam("id", id);}
}
