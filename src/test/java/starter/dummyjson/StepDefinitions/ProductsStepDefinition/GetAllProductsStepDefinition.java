package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import starter.dummyjson.DummyjsonResponses.ProductsResponses;
import java.io.File;
import static org.hamcrest.Matchers.*;

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
    @And("Should return any data that contain {string}")
    public void shouldReturnAnyDataThatContain(String keyword) {
        SerenityRest.then().assertThat()
                .body(Matchers.containsString(keyword));
    }
    @And("Get all products from search query JSON schema")
    public void getAllProductsFromSearchQueryJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsWithKeywordJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // SCENARIO 4
    @And("Should not contain any data")
    public void shouldNotContainAnyData() {
        SerenityRest.then().assertThat().body(ProductsResponses.PRODUCTS, Matchers.hasSize(0));
    }
    // SCENARIO 5
    @Given("Get all products categories from {string} parameter")
    public void getAllProductsCategories(String parameter) {
        getAll.getAllProductsCategories(parameter);
    }
    @When("Send request get all categories")
    public void sendRequestGetAllCategories() {
        SerenityRest.when().get(GetAllProductsApi.GET_ALL_CATEGORIES);
    }
    @And("Get all products categories JSON schema")
    public void getAllProductsCategoriesJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsCategoriesJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // SCENARIO 6
    @Given("Get all products from {string} categories")
    public void getAllProductsFromCategories(String keyword) {
        getAll.getAllProductsCategories(keyword);
    }
    @When("Send request to get all products from categories")
    public void sendRequestToGetAllProductsFromCategories() {
        SerenityRest.when().get(GetAllProductsApi.GET_ALL_PRODUCTS_BY_CATEGORY);
    }
    @And("Should return {string} on the category")
    public void shouldReturnOnTheCategory(String keyword) {
        SerenityRest.then().body(ProductsResponses.CATEGORY, Matchers.hasItem(keyword));
    }
    @And("Get all products from categories JSON schema")
    public void getAllProductsFromCategoriesJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/GetAllProductsByCategoriesJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //SCENARIO 7
}
