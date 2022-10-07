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

public class PutUpdatePostsStepDef {
    @Steps
    PostAPI postAPI;


    @Given("Put update post with valid posts id {int}")
    public void putUpdatePostWithValidId(int id) {
        File json = new File(PostAPI.JSON_FILE+"/PutUpdatePost.json");
        postAPI.putUpdatePost(id,json);
    }
    @When("Send request put update post")
    public void sendRequestPutUpdatePost() {
        SerenityRest.when().put(PostAPI.PUT_UPDATE_POST);
    }
    @Given("Put update post with invalid id {string}")
    public void putUpdatePostWithInvalidId(String id) {
        File json = new File(PostAPI.JSON_FILE+"/PutUpdatePost.json");
        postAPI.putUpdatePostInvalid("id",json);
    }
    @Given("Put update post without id")
    public void putUpdatePostWithoutId() {
        File json = new File(PostAPI.JSON_FILE+"/PutUpdatePostEmpty.json");
        postAPI.putUpdatePostEmpty(json);
    }
    @Given("Put update post with id {int} and invalid value")
    public void putUpdatePostWithIdAndInvalidValue(int id) {
        File json = new File(PostAPI.JSON_FILE+"/PutUpdatePostInvalid.json");
        postAPI.putUpdatePost(id,json);
    }
    @Given("Put update post with unregistered id {int} and invalid value")
    public void putUpdatePostWithUnregisteredIdAndInvalidValue(int id) {
        File json = new File(PostAPI.JSON_FILE+"/PutUpdatePostUnregisteredInvalid.json");
        postAPI.putUpdatePost(id,json);
    }
    @And("Response body should contain posts id {int}")
    public void responseBodyShouldContainPostsId(int id) {
        SerenityRest.then().body(PostsResponses.ID,equalTo(id));
    }
    @And("Put Update Posts json Schema Validator")
    public void gputUpdatePostsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/PutUpdatePostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

}
