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

public class GetSinglePostsStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Get single post with parameter {int}")
    public void getSinglePostWithParameter(int Id) {
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
    @And("Get single posts json Schema Validator")
    public void getSinglePostsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/GetSinglePostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Get single post with parameter {string}")
    public void getSinglePostWithParameter(String id) {
        postAPI.setGetSinglePostInvalid(id);
    }
}
