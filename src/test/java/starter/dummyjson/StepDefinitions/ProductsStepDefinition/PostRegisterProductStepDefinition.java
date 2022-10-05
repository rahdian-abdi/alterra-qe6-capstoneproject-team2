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
    @Given("Post register product valid parameter")
    public void post_register_product_valid_parameter() {
        File json = new File(PostRegisterProductApi.JSON_FILE+"/BodyRequest/Products/PostRegisterProduct.json");
        post.postValidParameter(json);
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
}
