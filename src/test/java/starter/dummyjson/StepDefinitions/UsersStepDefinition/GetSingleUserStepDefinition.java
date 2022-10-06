package starter.dummyjson.StepDefinitions.UsersStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI.GetAllUsersApi;
import starter.dummyjson.DummyjsonResponses.UsersResponse;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDefinition {

    @Steps
    GetAllUsersApi getAllUsersApi;

    @Given("Get single user with valid id {}")
    public void getSingleUserWithValidId (int id) {getAllUsersApi.getSingleUSer(id);}


    @When("Send request get single user")
    public void sendRequestGetSIngleUSer () {
        SerenityRest.when().get(GetAllUsersApi.GET_SINGLE_USER);}

    @And("Response body should contain {} {} {} {}")
    public void responseBodyShouldContain( int id, String firstName, String lastName, String maidenName) {
        SerenityRest.then()
                .body(UsersResponse.ID, equalTo(id))
                .body(UsersResponse.fisrtName, equalTo(firstName))
                .body(UsersResponse.lastName, equalTo(lastName))
                .body(UsersResponse.maidenName, equalTo(maidenName));}
    @And("Get single user json schema validator")
    public void getSingleUserJsonSchemaValidator() {
        File json = new File(GetAllUsersApi.JSON_SCHEMA_GET_ALL_USER + "/GetSingleUserJsonSchema1.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}







}
