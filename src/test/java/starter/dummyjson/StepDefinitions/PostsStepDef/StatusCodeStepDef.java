package starter.dummyjson.StepDefinitions.PostsStepDef;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;



public class StatusCodeStepDef {

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
