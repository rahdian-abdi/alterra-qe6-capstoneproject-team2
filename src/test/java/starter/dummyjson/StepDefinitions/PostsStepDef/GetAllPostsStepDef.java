package starter.dummyjson.StepDefinitions.PostsStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.PostsAPI.PostAPI;
import starter.dummyjson.DummyjsonResponses.PostsResponses;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetAllPostsStepDef {
    @Steps
    PostAPI postAPI;
    @Given("Get all posts with parameter {string}")
    public void getAllPostsWithValidParameter(String parameter) {
        postAPI.getAllPosts(parameter);
    }
    @When("Send request get all post")
    public void sendRequestGetAllPost() {
        SerenityRest.when().get(PostAPI.GET_ALL_POSTS);
    }

    @And("Response body should contain total posts {int}")
    public void responseBodyShouldContainTotalPostIs(int post) {
        SerenityRest.then().body(PostsResponses.TOTAL_POST,equalTo(post));
    }
    @And("Get all posts json Schema Validator")
    public void getAllPostsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/GetAllPostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }


}
