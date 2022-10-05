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

import static org.hamcrest.Matchers.equalTo;

public class PostStepDef {
    @Steps
    PostAPI postAPI;
    @Given("Get all posts with valid parameter {string}")
    public void getAllPostsWithValidParameter(String parameter) {
        postAPI.getAllPosts(parameter);
    }

    @When("Send request get all post")
    public void sendRequestGetAllPost() {
        SerenityRest.when().get(PostAPI.GET_ALL_POSTS);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(Integer OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain total post {int}")
    public void responseBodyShouldContainTotalPost(int post) {
        SerenityRest.then().body(PostsResponses.TOTAL_POST,equalTo(post));
    }

    @Given("Get single post with valid parameter {int}")
    public void getSinglePostWithValidParameter(int Id) {
        postAPI.setGetSinglePost(Id);
    }

    @When("Send request get single post")
    public void sendRequestGetSinglePost() {
        SerenityRest.when().get(PostAPI.GET_SINGLE_POST);
    }

    @And("Response body should contain id {int}")
    public void responseBodyShouldContainId(int id) {
        SerenityRest.then().body(PostsResponses.ID,equalTo(id));
    }

    @And("Get all posts json Schema Validator")
    public void getAllPostsJsonSchemaValidator() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Post/GetAllPostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Get single posts json Schema Validator")
    public void getSinglePostsJsonSchemaValidator() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Post/GetSinglePostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
