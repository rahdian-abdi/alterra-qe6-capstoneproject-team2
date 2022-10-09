package starter.dummyjson.API.ProductsAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAllProductsAuthApi {
    public static String URL = "https://dummyjson.com";
    public static String DIR = System.getProperty("user.dir");
    public static String JSON_FILE = DIR+"/src/test/resources/JSON";
    public static String AUTH_PARAMETER = URL+"/{parameter}/products";

    public static String VALID_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhdHVueTAiLCJlbWFpbCI6ImF0dW55MEBzb2h1LmNvbSIsImZpcnN0TmFtZSI6IlRlcnJ5IiwibGFzdE5hbWUiOiJNZWRodXJzdCIsImdlbmRlciI6Im1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vcm9ib2hhc2gub3JnL2hpY3ZlbGRpY3RhLnBuZyIsImlhdCI6MTY2NTA5NzU5OSwiZXhwIjoxNjY1MTAxMTk5fQ.u4tPvQl9bEB-mteYwF7YgRyTmvugHoMCPHzDBBv4GPQ";
    public static String INVALID_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhdHVueTAiLCJlbWFpbCI6ImF0dW55MEBzb2h1LmNvbSIsImZpcnN0TmFtZSI6IlRlcnJ5IiwibGFzdE5hbWUiOiJNZWRodXJzdCIsImdlbmRlciI6Im1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vcm9ib2hhc2gub3JnL2hpY3ZlbGRpY3RhLnBuZyIsImlhdCI6MTY2NTA5NzU5OSwiZXhwIjoxNjY1MTAxMTk5fQ.u4tPvQl9bEB-mteYwF7YgRyTmvugHoMCPHzDBBv4GPQthisisinvalid";
    public static String EXPIRED_TOKEN = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZz9zaXplPTUweDUwJnNldD1zZXQxIiwiaWF0IjoxNjM1NzczOTYyLCJleHAiOjE2MzU3Nzc1NjJ9.n9PQX8w8ocKo0dMCw3g8bKhjB8Wo7f7IONFBDqfxKhs";

    @Step("Get all products with authorization")
    public void getAllProductsAuth(String parameter) {
        SerenityRest.given()
                .pathParam("parameter", parameter)
                .headers("Authorization", VALID_TOKEN);
    }
    @Step("Get all products with invalid authorization")
    public void getAllProductsInvalidAuth(String parameter) {
        SerenityRest.given()
                .pathParam("parameter", parameter)
                .headers("Authorization", INVALID_TOKEN);
    }
    @Step("Get all products with expired authorization")
    public void getAllProductsExpiredAuth(String parameter) {
        SerenityRest.given()
                .pathParam("parameter", parameter)
                .headers("Authorization", EXPIRED_TOKEN);
    }

}
