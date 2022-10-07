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
import starter.dummyjson.API.ProductsAPI.PutUpdateProductApi;
import starter.dummyjson.DummyjsonResponses.ProductsResponses;
import java.io.File;
import static org.hamcrest.Matchers.*;

public class PutUpdateProductStepDefinition {
    @Steps
    PutUpdateProductApi put;
    @Given("Update product on id {int}")
    public void update_product_on_id(Integer id) {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/BodyRequest/Products/PutUpdateProduct.json");
        put.putUpdateProduct(id, json);
    }
    @When("Send request update product")
    public void send_request_update_product() {
        SerenityRest.when().put(PutUpdateProductApi.UPDATE_PARAMETER);
    }
    @Then("Should return {int} OK or {int} No Content status code")
    public void should_return_ok_or_no_content_status_code(Integer statusPrime, Integer statusSecondary) {
        SerenityRest.then().statusCode(anyOf(is(statusPrime), is(statusSecondary)));
    }
    @Then("Should return {string} on id")
    public void should_return_on_id(String id) {
        SerenityRest.then().body(ProductsResponses.PRODUCT_ID, equalTo(id));
    }
    @Then("Update product registered id JSON schema")
    public void update_product_registered_id_json_schema() {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/SchemaValidator/Products/PutUpdateProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Should return {string} on message")
    public void shouldReturnOnMessage(String message) {
        SerenityRest.then().assertThat().body(ProductsResponses.MESSAGE_NOT_FOUND, Matchers.containsString(message));
    }

    @And("Update product unregistered id JSON schema")
    public void updateProductUnregisteredIdJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/PutProductUnregisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @Given("Update product on parameter {string}")
    public void updateProductOnParameter(String parameter) {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/BodyRequest/Products/PutUpdateProduct.json");
        put.putUpdateProductInvalid(parameter, json);
    }
    @When("Send request update product invalid parameter")
    public void sendRequestUpdateProductInvalidParameter() {
        SerenityRest.when().put(PutUpdateProductApi.UPDATE_INVALID_PARAMETER);
    }

    @Given("Update product on id {int} and empty request body")
    public void updateProductOnIdAndEmptyRequestBody(int id) {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/BodyRequest/Products/PutUpdateProductEmpty.json");
        put.putUpdateProduct(id, json);
    }
    @Given("Update product on id {string}")
    public void updateProductOnId(String id) {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/BodyRequest/Products/PutUpdateProduct.json");
        put.putUpdateProductInvalidId(id, json);
    }
    @When("Send request update product invalid id")
    public void sendRequestUpdateProductInvalidId() {
        SerenityRest.when().put(PutUpdateProductApi.UPDATE_PARAMETER);
    }
}
