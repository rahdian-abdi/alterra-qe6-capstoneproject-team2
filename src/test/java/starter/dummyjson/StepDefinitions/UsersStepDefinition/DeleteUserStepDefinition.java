package starter.dummyjson.StepDefinitions.UsersStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.UsersAPI.DeleteUsersApi;
import starter.dummyjson.API.UsersAPI.UpdateUserApi;

import java.io.File;


public class DeleteUserStepDefinition {
    @Steps
    DeleteUsersApi deleteUsersApi;

    @Given("Delete user with registered id {}")
    public void deleteUserWithRegisteredId (int id) {deleteUsersApi.deleteUser(id);}

    @When("Send request delete user")
    public void sendRequestDeleteUser () {
        SerenityRest.when().delete(DeleteUsersApi.DELETE_USER);}

    @And("Delete user registered id json schema validator")
    public void deleteUserRegisteredIdJsonSchemaValidator() {
        File json = new File(DeleteUsersApi.DELETE_USER_JSON_SCHEMA + "/DeleteUserRegisteredIdSchemaValidator.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete user with Unregistered Id {}")
    public void deleteUserWithUnregisteredId(int id) {deleteUsersApi.deleteUser(id);}

    @And("Delete user unregistered id json schema validator")
    public void deleteUserUnregisteredIdJsonSchemaValidator() {File json = new File(DeleteUsersApi.DELETE_USER_JSON_SCHEMA + "/DeleteUserUnregisteredIdJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
