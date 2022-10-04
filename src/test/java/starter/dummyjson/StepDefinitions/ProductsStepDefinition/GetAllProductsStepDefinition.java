package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

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
}
