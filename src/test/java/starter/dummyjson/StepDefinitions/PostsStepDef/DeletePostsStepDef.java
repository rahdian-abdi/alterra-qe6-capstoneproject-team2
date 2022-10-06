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

public class DeletePostsStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Delete post with valid id {int}")
    public void deletePostWithValidId(int id) {
        postAPI.deletePost(id);
    }

    @When("Send request delete post")
    public void sendRequestDeletePost() {
        SerenityRest.when().delete(PostAPI.DELETE_POST);
    }

    @Given("Delete post with invalid id {string}")
    public void deletePostWithInvalidId(String id) {
        postAPI.deletePostInvalid(id);
    }

    @Given("Delete post with unregistered id {int}")
    public void deletePostWithUnregisteredId(int id) {
        postAPI.deletePost(id);
    }
    @And("Response body should contain {string} on isDeleted")
    public void responseBodyShouldContainOnIsDeleted(String delete) {
        SerenityRest.then().body(PostsResponses.TOTAL_POST,equalTo(delete));
    }

    @And("Delete post json Schema Validator")
    public void deletePostJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/DeletePostJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

}
