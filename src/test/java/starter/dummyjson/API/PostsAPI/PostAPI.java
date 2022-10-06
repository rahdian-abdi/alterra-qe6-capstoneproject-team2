package starter.dummyjson.API.PostsAPI;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class PostAPI {
    public static String URL = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/JSON/File/Posts";
    public static final String JSON_VALIDATOR = DIR+"/src/test/resources/JSON/SchemaValidator/Post";

    public static String GET_ALL_POSTS = URL+"/{parameter}";
    public static String GET_SINGLE_POST = URL+"/posts/{id}";
    public static String GET_SEARCH_POST_EMPTY = URL+"/posts/{search}";
    public static String GET_SEARCH_POST = URL+"/posts/search?q={key}";
    public static String CREATE_NEW_POST = URL+"/posts/add";
    public static String PUT_UPDATE_POST = URL+"/posts/{id}";
    public static String PUT_UPDATE_POST_EMPTY = URL+"/posts";
    public static String DELETE_POST = URL+"/posts/{id}";
    public static String GET_ALL_POSTS_BY_USER_ID = URL+"/posts/user/{id}";
    public static String GET_POSTS_COMMENTS = URL+"/posts/{id}/comments";





    @Step ("Get all posts")
    public void getAllPosts(String parameter) {
        SerenityRest.given().pathParam("parameter", parameter);
    }
    @Step("Get post comments")
    public void getPostsComments(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get post comments Invalid")
    public void getPostsCommentsInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get all posts by user id")
    public void getAllPostsByUserId(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Get all posts by invalid user id")
    public void getAllPostsByInvalidUserId(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step ("Get single posts")
    public void setGetSinglePost(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step ("Get Single Posts invalid")
    public void setGetSinglePostInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step ("Get Search post empty")
    public void setGetSearchPostEmpty(String search){
        SerenityRest.given().pathParam("search",search);
    }
    @Step ("Get Search post")
    public void setGetSearchPost(String key){
        SerenityRest.given().pathParam("key",key);
    }
    @Step ("Post new post with valid id")
    public void postNewPostWithValidId(File json){
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update post")
    public void putUpdatePost(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update post invalid")
    public void putUpdatePostInvalid(String id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update post empty")
    public void putUpdatePostEmpty(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update post")
    public void patchUpdatePost(int id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update post invalid")
    public void patchUpdatePostInvalid(String id,File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update post empty")
    public void patchUpdatePostEmpty(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("delete post")
    public void deletePost(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("delete post invalid")
    public void deletePostInvalid(String id){
        SerenityRest.given().pathParam("id",id);
    }



}
