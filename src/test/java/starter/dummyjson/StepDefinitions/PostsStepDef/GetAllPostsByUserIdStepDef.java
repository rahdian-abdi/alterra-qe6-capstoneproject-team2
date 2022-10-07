package starter.dummyjson.StepDefinitions.PostsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.PostsAPI.PostAPI;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.DummyjsonResponses.PostsResponses;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetAllPostsByUserIdStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Get all posts with valid user id {int}")
    public void getAllPostsWithValidUserId(int id) {
        postAPI.getAllPostsByUserId(id);
    }

    @When("Send request get all posts")
    public void sendRequestGetAllPosts() {
        SerenityRest.when().get(PostAPI.GET_ALL_POSTS_BY_USER_ID);
    }

    @Given("Get all posts with invalid user id {string}")
    public void getAllPostsWithInvalidUserId(String id) {
        postAPI.getAllPostsByInvalidUserId(id);
    }

    @Given("Get all posts with unregistered user id {int}")
    public void getAllPostsWithUnregisteredUserId(int id) {
        postAPI.getAllPostsByUserId(id);
    }
    @And("Response body should contain user id {int}")
    public void responseBodyShouldContainUserId(int id) {
        SerenityRest.then().body(PostsResponses.USER_ID,equalTo(id));
    }

    @And("Get all posts by user id json Schema Validator")
    public void getAllPostsByUserIdJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/GetAllPostsByUserIdJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }
}
