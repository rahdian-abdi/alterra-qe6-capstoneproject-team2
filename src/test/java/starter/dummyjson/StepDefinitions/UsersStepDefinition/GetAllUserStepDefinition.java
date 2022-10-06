package starter.dummyjson.StepDefinitions.UsersStepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI.GetAllUsersApi;

import java.io.File;

public class GetAllUserStepDefinition {
    @Steps
    GetAllUsersApi getAllUsersApi;

    @Given("Get all users with valid path")
    public void getAllUsersWithValidPath() {
        getAllUsersApi.getAllUser();}

    @When("Send request get all users")
    public void sendRequestGetAllUsers() {
        SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER);}

    @Then("Status should return {int} OK")
    public void statusShouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);}

    @And("Get all user json schema validator")
    public void getAllUserJsonSchemaValidator() {
        File json = new File(GetAllUsersApi.JSON_SCHEMA_GET_ALL_USER + "/GetAllUsersJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));}


    @Given("Get all users with invalid path")
    public void getAllUsersWithInvalidPath() {
        getAllUsersApi.getAllUserInvalid();}

    @When("Send request get all users invalid path")
    public void sendRequestGetAllUsersInvalidPath() {
        SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER_INVALID_1);}

    @Then("Status should return {int} Not Found")
    public void statusShouldReturnNotFound(int Not_Found) {
        SerenityRest.then().statusCode(Not_Found);}

    @When("Send request get all users with adding letters on path")
    public void sendRequestGetAllUsersWithAddingLettersOnPath() {SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER_INVALID_2);}

    @Given("Get all users with adding {} on path")
    public void getAllUsersWithAddingNumberOnPath(int number) {getAllUsersApi.getAllUserInvalidAddingNumber(number);}

    @When("Send request get all users adding number on path")
    public void sendRequestGetAllUsersAddingNumberOnPath() {SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER_INVALID_3);}


    @Given("Get all users with add numbers {} on path")
    public void getAllUsersWithAddingNumbersOnPath(int numbers) {getAllUsersApi.getAllUserInvalidAddingNumbers(numbers);}

    @When("Send request get all users adding numbers on path")
    public void sendRequestGetAllUsersAddingNumbersOnPath() {SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER_INVALID_3_NUMBERS);}


    @Given("Get all users with adding special characters {} after path")
    public void getAllUsersWithAddingSpecialCharacterfterPath(String characters) {getAllUsersApi.getAllUsersInvalidWithSpecialCharacters(characters);}


    @When("Send request get all users adding special character on path")
    public void sendRequestGetAllUsersAddingSpecialCharacterOnPath() {SerenityRest.when().get(GetAllUsersApi.GET_ALL_USER_INVALID_3_CHARACTERS);}
}


