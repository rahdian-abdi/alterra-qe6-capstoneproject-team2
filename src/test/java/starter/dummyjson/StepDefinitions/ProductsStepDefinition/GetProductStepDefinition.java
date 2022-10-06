package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.API.ProductsAPI.GetProductApi;
import starter.dummyjson.DummyjsonResponses.ProductsResponses;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class GetProductStepDefinition {
    @Steps
    GetProductApi get;
    // SCENARIO 8
    @Given("Get product from id {int}")
    public void get_product_from_id(Integer id) {
        get.getSingleProductWithId(id);
    }
    @When("Send request get single product")
    public void send_request_get_single_product() {
        SerenityRest.when().get(GetProductApi.GET_SINGLE_PRODUCT);
    }
    @Then("Body response should display id {int}")
    public void body_response_should_display_id(Integer id) {
        SerenityRest.then().assertThat().body(ProductsResponses.PRODUCT_ID, equalTo(id));
    }
    @Then("Get single product JSON schema")
    public void get_single_product_json_schema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetProductRegisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // SCENARIO 9
    @And("Body response should display message {string}")
    public void bodyResponseShouldDisplayMessage(String message) {
        SerenityRest.then().assertThat().body(ProductsResponses.MESSAGE_NOT_FOUND, Matchers.containsString(message));
    }
    @And("Get single product unregistered JSON schema")
    public void getSingleProductUnregisteredJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetProductUnregisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
