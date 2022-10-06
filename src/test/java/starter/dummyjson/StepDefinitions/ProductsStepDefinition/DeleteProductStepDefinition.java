package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.dummyjson.API.ProductsAPI.DeleteProductApi;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.DummyjsonResponses.ProductsResponses;

import static org.hamcrest.Matchers.*;
import java.io.File;

public class DeleteProductStepDefinition {
    @Steps
    DeleteProductApi delete;
    @Given("Delete product with id {int}")
    public void delete_product_with_id(Integer id) {
        delete.deleteProduct(id);
    }
    @When("send request delete product")
    public void send_request_delete_product() {
        SerenityRest.when().delete(DeleteProductApi.DELETE_PRODUCT);
    }
    @And("Should display deleted status {string}")
    public void shouldDisplayDeletedStatusTrue(String status) {
        SerenityRest.then().assertThat().body(ProductsResponses.IS_DELETED, equalTo(Boolean.parseBoolean(status)));
    }
    @And("Delete product JSON schema")
    public void deleteProductJsonSchema() {
        File json = new File(DeleteProductApi.JSON_FILE+"//SchemaValidator/Products/DeleteProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Delete product unregistered JSON schema")
    public void deleteProductUnregisteredJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/DeleteProductUnregisteredJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete product with id {string}")
    public void deleteProductWithId(String id) {
        delete.deleteProductInvalidId(id);
    }
}
