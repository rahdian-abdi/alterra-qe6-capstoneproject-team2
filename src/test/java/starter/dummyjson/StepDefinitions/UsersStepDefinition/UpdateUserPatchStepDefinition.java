package starter.dummyjson.StepDefinitions.UsersStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI.UpdateUserApi;
import starter.dummyjson.API.UsersAPI.UpdateUserPatchApi;

import java.io.File;

public class UpdateUserPatchStepDefinition {
    @Steps
    UpdateUserPatchApi updateUserPatchApi;

    @Given("Update user first name and last name body data")
    public void updateUserFirstNameAndLastNameBodyData () {
        File json = new File(UpdateUserPatchApi.UPDATE_USER_PATCH_BODY_REQUEST + "/UpdateUserPatch.json");
        updateUserPatchApi.updateuserPatch(json);}

    @When("Send request update user patch")
    public void sendRequestUpdateUserPatch () {
        SerenityRest.when().patch(UpdateUserPatchApi.UPDATE_USER_PATCH_REGISTERED);}


    @And("Update user patch registered id json schema validator")
    public void updateUserPatchRegisteredIdJsonSchemaValidator() {File json = new File(UpdateUserPatchApi.UPDATE_USER_PATCH_JSON_SCHEMA + "/UpdateUserPatchRegisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Update user height and weight body data")
    public void updateUserHeightAndWeightBodyData() {File json = new File(UpdateUserPatchApi.UPDATE_USER_PATCH_BODY_REQUEST + "/UpdateUserHeightAndWeight.json");
        updateUserPatchApi.updateuserPatch(json);}

    @When("Send request update user patch unregistered id")
    public void sendRequestUpdateUserPatchUnregisteredId() { SerenityRest.when().patch(UpdateUserPatchApi.UPDATE_USER_PATCH_UNREGISTERED);}

    @And("Update user patch unregistered id json schema validator")
    public void updateUserPatchUnregisteredIdJsonSchemaValidator() {File json = new File(UpdateUserPatchApi.UPDATE_USER_PATCH_JSON_SCHEMA + "/UpdateUserPatchUnregisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}
}
