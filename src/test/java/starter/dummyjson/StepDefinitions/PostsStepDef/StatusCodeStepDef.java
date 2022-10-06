package starter.dummyjson.StepDefinitions.PostsStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.dummyjson.API.PostsAPI.PostAPI;
import starter.dummyjson.DummyjsonResponses.PostsResponses;

import java.io.File;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class StatusCodeStepDef {
    @Steps
    PostAPI postAPI;

    @Then("Should return {int} OK")
    public void shouldReturnOK(Integer OK) {
        SerenityRest.then().statusCode(OK);
    }
    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }



}
