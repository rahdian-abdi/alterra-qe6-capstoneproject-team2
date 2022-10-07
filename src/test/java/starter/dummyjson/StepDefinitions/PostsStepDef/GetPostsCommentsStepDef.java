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

public class GetPostsCommentsStepDef {
    @Steps
    PostAPI postAPI;


    @Given("Get post comments with valid post id {int}")
    public void getPostCommentsWithValidPostId(int id) {
        postAPI.getPostsComments(id);
    }
    @When("Send request get posts comments")
    public void sendRequestGetPostsComments() {
        SerenityRest.when().get(PostAPI.GET_POSTS_COMMENTS);
    }
    @Given("Get post comments with invalid post id {string}")
    public void getPostCommentsWithInvalidPostId(String id) {
        postAPI.getPostsCommentsInvalid(id);
    }
    @Given("Get post comments with unregistered post id {int}")
    public void getPostCommentsWithUnregisteredPostId(int id) {
        postAPI.getAllPostsByUserId(id);
    }
    @And("Response body should contain comments posts id {int}")
    public void responseBodyShouldContainCommentsPostsId(int id) {
        SerenityRest.then().body(PostsResponses.COMMENTS_POST_ID,equalTo(id));
    }
    @And("Get Posts Comments json Schema Validator")
    public void getPostsCommentsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/GetPostsCommentsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
