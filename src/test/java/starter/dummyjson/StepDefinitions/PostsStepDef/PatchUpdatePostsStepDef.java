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

public class PatchUpdatePostsStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Patch update post with valid id {int}")
    public void patch_update_post_with_valid_id(Integer id) {
        File json = new File(PostAPI.JSON_FILE+"/PatchUpdatePostValid.json");
        postAPI.patchUpdatePost(id,json);
    }
    @When("Send request patch update post")
    public void send_request_patch_update_post() {
        SerenityRest.when().put(PostAPI.PUT_UPDATE_POST);
    }
    @Given("Patch update post with invalid id {string}")
    public void patch_update_post_with_invalid_id(String id) {
        File json = new File(PostAPI.JSON_FILE+"/PatchUpdatePost.json");
        postAPI.patchUpdatePostInvalid(id,json);
    }
    @Given("Patch update post with unregistered id {int}")
    public void patch_update_post_with_unregistered_id(int id) {
        File json = new File(PostAPI.JSON_FILE+"/PatchUpdatePost.json");
        postAPI.patchUpdatePost(id,json);
    }
    @And("Patch Update posts json schema validator")
    public void patchUpdatePostsJsonSchemaValidator() {
        File json = new File (PostAPI.JSON_VALIDATOR+"/PatchUpdatePostsJsonSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response posts body should contain posts title {string}")
    public void responsePostsBodyShouldContainPostsTitle(String title) {
        SerenityRest.then().body(PostsResponses.TITLE,equalTo(title));
    }

}
