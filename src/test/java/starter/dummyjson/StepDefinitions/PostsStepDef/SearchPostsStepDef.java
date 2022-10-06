package starter.dummyjson.StepDefinitions.PostsStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.apache.xerces.xinclude.XIncludeMessageFormatter;
import starter.dummyjson.API.PostsAPI.PostAPI;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.DummyjsonResponses.PostsResponses;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class SearchPostsStepDef {
    @Steps
    PostAPI postAPI;

    @Given("Get search post without parameter")
    public void getSearchPostWithoutParameter() {
        postAPI.setGetSearchPost("search");
    }
    @When("Send request get search post empty")
    public void sendRequestGetSearchPostEmpty() {
        SerenityRest.when().get(PostAPI.GET_SEARCH_POST_EMPTY);
    }
    @Then("Response body should contain {int} post")
    public void responseBodyShouldContainAllPost(int total) {
        SerenityRest.then().body(PostsResponses.TOTAL_POST,equalTo(total));
    }
    @And("Get search post json Schema Validator")
    public void getSearchPostJsonSchemaValidator() {
    }
    @Given("Get search post with parameter {string}")
    public void getSearchPostWithParameter(String parameter) {
        postAPI.setGetSearchPost(parameter);
    }
    @When("Send request get search post")
    public void sendRequestGetSearchPost() {
        SerenityRest.when().get(PostAPI.GET_SEARCH_POST);
    }
    @Then("Response body should contain keyword {string}")
    public void responseBodyShouldContainKeyword(String key) {
        SerenityRest.then().body(PostsResponses.KEYWORD,equalTo(key));
    }
}
