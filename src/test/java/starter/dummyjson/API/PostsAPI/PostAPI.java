package starter.dummyjson.API.PostsAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PostAPI {
    public static String URL = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON";

    public static String GET_ALL_POSTS = URL+"/{parameter}";
    public static String GET_SINGLE_POST = URL+"/posts/{id}";
    @Step ("Get all posts")
    public void getAllPosts(String parameter) {
        SerenityRest.given().pathParam("parameter", parameter);
    }
    @Step ("Get single posts")
    public void setGetSinglePost(int id) {
        SerenityRest.given().pathParam("id", id);
    }

}
