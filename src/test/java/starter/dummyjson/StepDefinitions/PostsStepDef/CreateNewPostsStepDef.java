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

public class CreateNewPostsStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Post new post with valid user id")
    public void postNewPostWithValidUserId() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithValidUserId.json");
        postAPI.postNewPostWithValidId(json);
    }
    @When("Send request post new post")
    public void sendRequestPostNewPost() {
        SerenityRest.when().post(PostAPI.CREATE_NEW_POST);
    }
    @And("Response body should contain posts id {int} and title {string}")
    public void responseBodyShouldContainIdAndTitle(int id, String title) {
        SerenityRest.then()
                .body(PostsResponses.ID,equalTo(id))
                .body(PostsResponses.TITLE,equalTo(title));
    }

    @Given("Post new post with invalid user id")
    public void postNewPostWithInvalidUserId() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithInvalidUserId.json");
        postAPI.postNewPostWithValidId(json);
    }

    @Given("Post new post without user id")
    public void postNewPostWithoutUserId() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithoutUserId.json");
        postAPI.postNewPostWithValidId(json);
    }


    @Given("Post new post with unregistered user id")
    public void postNewPostWithUnregisteredUserId() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithUnregisteredUserId.json");
        postAPI.postNewPostWithValidId(json);
    }

    @Given("Post new post registered user id  and empty value")
    public void postNewPostRegisteredUserIdAndEmptyValue() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithValidUserIdEmpty.json");
        postAPI.postNewPostWithValidId(json);
    }

    @Given("Post new post unregistered user id  and empty value")
    public void postNewPostUnregisteredUserIdAndEmptyValue() {
        File json = new File(PostAPI.JSON_FILE+"/PostNewPostWithUnregisteredUserIdEmpty.json");
        postAPI.postNewPostWithValidId(json);
    }

    @And("Post new posts json schema validator")
    public void postNewPostsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/CreateNewPostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



}
