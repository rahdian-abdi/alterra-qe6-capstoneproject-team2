package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.API.ProductsAPI.PostRegisterProductApi;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import java.io.File;

public class PostRegisterProductStepDefinition {
    @Steps
    PostRegisterProductApi post;
    @Given("Post register product")
    public void post_register_product() {
        File json = new File(PostRegisterProductApi.JSON_FILE+"/BodyRequest/Products/PostRegisterProduct.json");
        post.postBodyRequest(json);
    }
    @When("Send request post product")
    public void send_request_post_product() {
        SerenityRest.when().post(PostRegisterProductApi.POST_VALID_PARAMETER);
    }
    @Then("Should return {int} OK or {int} Created status code")
    public void should_return_ok_or_created_status_code(Integer statusMain, Integer statusSecondary) {
        SerenityRest.then().statusCode(anyOf(is(statusMain), is(statusSecondary)));
    }
    @Then("Post register product valid parameter JSON schema")
    public void post_register_product_valid_parameter_json_schema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/PostRegisterProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("Send request post product invalid parameter")
    public void sendRequestPostProductInvalidParameter() {
        SerenityRest.when().post(PostRegisterProductApi.POST_INVALID_PARAMETER);
    }

    @Given("Post register product incomplete body request")
    public void postRegisterProductIncompleteBodyRequest() {
        File json = new File(PostRegisterProductApi.JSON_FILE+"/BodyRequest/Products/PostRegisterProductIncomplete.json");
        post.postBodyRequest(json);
    }
    @Then("Should return {int} Bad Request status code")
    public void shouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @Given("Post register product empty body request")
    public void postRegisterProductEmptyBodyRequest() {
        File json = new File(PostRegisterProductApi.JSON_FILE+"/BodyRequest/Products/PostRegisterProductEmpty.json");
        post.postBodyRequest(json);
    }

    @Given("Post register product invalid data type body request")
    public void postRegisterProductInvalidDataTypeBodyRequest() {
        File json = new File(PostRegisterProductApi.JSON_FILE+"/BodyRequest/Products/PostRegisterProductInvalidDataType.json");
        post.postBodyRequest(json);
    }
}
