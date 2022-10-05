package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.DummyjsonResponses.ProductsResponses;
import io.restassured.module.jsv.JsonSchemaValidator;
import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetAllProductsStepDefinition {
    @Steps
    GetAllProductsApi getAll;

    // SCENARIO 1
    @Given("Get all products from {string} parameter")
    public void get_all_products_from_parameter(String parameter) {
        getAll.getAllProducts(parameter);
    }
    @When("Send request get all products")
    public void send_request_get_all_products() {
        SerenityRest.when().get(GetAllProductsApi.GET_ALL_PRODUCTS);
    }
    @Then("Should return {int} OK status code")
    public void should_return_ok_status_code(Integer statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    @Then("Get all products JSON schema")
    public void get_all_products_json_schema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // SCENARIO 2
    @Then("Should return {int} Not Found status code")
    public void shouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
    // SCENARIO 3
    @Given("Get all products from search query with {string} keyword")
    public void getAllProductsFromSearchQueryWithKeyword(String keyword) {
        getAll.getAllProductsWithKeyword(keyword);
    }
    @When("Send request get all search products")
    public void sendRequestGetAllSearchProducts() {
        SerenityRest.when().get(GetAllProductsApi.GET_ALL_PRODUCTS_WITH_KEYWORD);
    }

    @And("Get all products from search query JSON schema")
    public void getAllProductsFromSearchQueryJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsWithKeywordJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // SCENARIO 4
    @And("Get all precluded products from search query JSON schema")
    public void getAllPrecludedProductsFromSearchQueryJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsWithPrecludedKeywordJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
