package starter.dummyjson.StepDefinitions.UsersStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import starter.dummyjson.API.UsersAPI.UpdateUserApi;
import starter.dummyjson.DummyjsonResponses.UsersResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserStepDefinition {

    @Steps
    UpdateUserApi updateUserApi;


    @Given("Update user with body data")
    public void updateUserPathWithValidRegisteredId () {File json = new File(UpdateUserApi.UPDATE_USER_BODY_REQUEST + "/UpdateUserPatch.json");
        updateUserApi.setUpdateBodyData(json);}

    @When("Send request update user by id")
    public void sendRequestUpdateUserByid () {SerenityRest.when().put(UpdateUserApi.UPDATE_USER);}

    @And ("Updated user body should return to requested data {}")
    public void updatedUserBodyShouldReturnToRequestedData (String firstName) {
        SerenityRest.then()
                .body(UsersResponse.fisrtName, equalTo(firstName));}

    @Given("Update user with valid body data")
    public void updateUserWithValidBodyData() {File json = new File(UpdateUserApi.UPDATE_USER_BODY_REQUEST + "/UpdateUserUnregistered.json");
        updateUserApi.setUpdateBodyData(json);}
    @When("Send request update user by invalid id")
    public void sendRequestUpdateUserByInvalidId() {SerenityRest.when().patch(UpdateUserApi.UPDATE_USER_UNREGISTERED);}


    @And("Update user unregistered id json schema validator")
    public void updateUserUnregisteredIdJsonSchemaValidator() {File json = new File(UpdateUserApi.UPDATE_USER_JSON_SCHEMA + "/UpdateUserSpecialCharacterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Update user with empty body value")
    public void updateUserWithEmptyBodyValue() {File json = new File(UpdateUserApi.UPDATE_USER_BODY_REQUEST + "/UpdateUserEmptyValueBody.json");
        updateUserApi.setUpdateBodyData(json);}


    @And("Update user empty body value json schema validation")
    public void updateUserEmptyBodyValueJsonSchemaValidation() {File json = new File(UpdateUserApi.UPDATE_USER_JSON_SCHEMA + "/UpdateUserEmptyValueBodyJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @When("Send request update user path with special character")
    public void sendRequestUpdateUserPathWithSpecialCharacter() {SerenityRest.when().patch(UpdateUserApi.UPDATE_USER_SPECIAL_CHARACTER);}

    @And("Update user special character path json schema validation")
    public void updateUserSpecialCharacterPathJsonSchemaValidation() {File json = new File(UpdateUserApi.UPDATE_USER_JSON_SCHEMA + "/UpdateUserSpecialCharacterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Update user with special character id body data")
    public void updateUserWithSpecialCharacterIdBodyData() {File json = new File(UpdateUserApi.UPDATE_USER_BODY_REQUEST + "/UpdateUserSpecialCharacter.json");
        updateUserApi.setUpdateBodyData(json);}
}
