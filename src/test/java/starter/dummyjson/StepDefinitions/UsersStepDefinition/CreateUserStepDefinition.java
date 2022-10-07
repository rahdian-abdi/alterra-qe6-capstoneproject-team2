package starter.dummyjson.StepDefinitions.UsersStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI.CreateUsersApi;

import starter.dummyjson.DummyjsonResponses.UsersResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateUserStepDefinition {


    @Steps
    CreateUsersApi createUsersApi;

    @Given("Create user with valid body data")
    public void createUserWithValidBodyData () { File json = new File(CreateUsersApi.CREATE_USER_BODY_REQUEST + "/CreateUserwithBodyData.json");
        createUsersApi.createUserBodyData(json);}

    @When("Send request create user")
    public void sendRequestCreateUser () {
        SerenityRest.when().post(CreateUsersApi.CREATE_USER);}

    @And("body response should return to unused id {} with body data")
    public void bodyResponseShouldReturnToUnusedIdWithBodyData(int id) {SerenityRest.then().body(UsersResponse.ID, equalTo(id));}

    @And("Create user with body data json schema validator")
    public void createUserWithBodyDataJsonSchemaValidator () {
        File json = new File(CreateUsersApi.CREATE_USER_JSON_SCHEMA_VALIDATOR + "/CreateUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Create user with empty body data")
    public void createUserWithEmptyBodyData() {File json = new File(CreateUsersApi.CREATE_USER_BODY_REQUEST + "/CreateUserwithEmptyValue.json");
        createUsersApi.createUserBodyData(json);}

    @Given("Create user with valid registered id on body data")
    public void createUserWithValidRegisteredIdOnBodyData() {File json = new File(CreateUsersApi.CREATE_USER_BODY_REQUEST + "/CreateUserwithRegisteredId.json");
        createUsersApi.createUserBodyData(json);}

    @And("Body should return to unused id {} automatically with body data")
    public void bodyShouldReturnToUnusedIdAutomaticallyWithBodyData(int id) {SerenityRest.then().body(UsersResponse.ID, equalTo(id));}

    @And("Create user with valid registered id json schema validation")
    public void createUserWithValidRegisteredIdJsonSchemaValidation() {File json = new File(CreateUsersApi.CREATE_USER_JSON_SCHEMA_VALIDATOR + "/CreateUserwithRegisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Create user with special chacarter in on body data")
    public void createUserWithSpecialChacarterInOnBodyData() {File json = new File(CreateUsersApi.CREATE_USER_BODY_REQUEST + "/CreateUserwithSpecialCharacter.json");
        createUsersApi.createUserBodyData(json);}

    @And("Create user with special character json schema validation")
    public void createUserWithSpecialCharacterJsonSchemaValidation() {File json = new File(CreateUsersApi.CREATE_USER_JSON_SCHEMA_VALIDATOR + "/CreateUserwithSpecialCharacterJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}

    @Given("Create user with empty id on body data")
    public void createUserWithEmptyIdOnBodyData() {File json = new File(CreateUsersApi.CREATE_USER_BODY_REQUEST + "/CreateUserWithEmptyId.json");
        createUsersApi.createUserBodyData(json);}

    @And("Create user with empty id json schema validation")
    public void createUserWithEmptyIdJsonSchemaValidation() {File json = new File(CreateUsersApi.CREATE_USER_JSON_SCHEMA_VALIDATOR + "/CreateUserwithRegisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}
}
