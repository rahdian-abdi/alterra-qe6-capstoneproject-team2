package starter.dummyjson.StepDefinitions.ProductsStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.ProductsAPI.GetAllProductsApi;
import starter.dummyjson.API.ProductsAPI.PatchProductApi;
import starter.dummyjson.API.ProductsAPI.PutUpdateProductApi;

import java.io.File;

public class PatchUpdateProductStepDefinition {
    @Steps
    PatchProductApi patch;
    @Given("Patch update product with id {int}")
    public void patch_update_product_with_id(Integer id) {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/BodyRequest/Products/PatchUpdateProduct.json");
        patch.patchUpdateProduct(id, json);
    }
    @When("Send request patch product")
    public void send_request_patch_product() {
        SerenityRest.when().patch(PatchProductApi.PATCH_PARAMETER);
    }

    @And("Update patch product registered id JSON schema")
    public void updatePatchProductRegisteredIdJSONSchema() {
        File json = new File(PutUpdateProductApi.JSON_FILE+"/SchemaValidator/Products/PatchUpdateProductJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Update patch product unregistered id JSON schema")
    public void updatePatchProductUnregisteredIdJSONSchema() {
        File json = new File(GetAllProductsApi.JSON_FILE+"/SchemaValidator/Products/PatchUpdateProductUnregisteredJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
