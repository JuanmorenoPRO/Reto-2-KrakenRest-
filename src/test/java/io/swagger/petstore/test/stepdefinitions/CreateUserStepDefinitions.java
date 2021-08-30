package io.swagger.petstore.test.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.eo.Se;
import io.swagger.petstore.test.steps.CreateUserSteps;
import io.swagger.petstore.test.steps.PlaceAnOrderSteps;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.Map;

public class CreateUserStepDefinitions {

    //Service #1 Create User

    @Steps
    CreateUserSteps createUserSteps;

    @Steps
    PlaceAnOrderSteps placeAnOrderSteps;

    @Given("^A user send the request to create a new user in the endpoint \"([^\"]*)\"$")
    public void aUserSendTheRequestToCreateANewUserInTheEndpoint(String url, Map<String, String> body) {
        SerenityRest.given().baseUri(url).header("Content-Type","application/json").body(body).post();
        SerenityRest.lastResponse().then().log().all();
       // createUserSteps.sendRequest(url, body);
    }

    @Then("^Validate that the status code is (\\d+)$")
    public void validateThatTheStatusCodeIs(int statusCode) {
        createUserSteps.validateStatus(statusCode);
    }
    @And("^Validate that the response must be \"([^\"]*)\"$")
    public void validateThatTheResponseMustBe(String pathStructure) {
        createUserSteps.validateStructure(pathStructure);
    }


    @And("^Validate that the response contains the key \"([^\"]*)\" must be \"([^\"]*)\"$")
    public void validateThatTheResponseContainsTheKeyMustBe(String type, String typeStatus) {
       createUserSteps.validateType(type, typeStatus);
    }

    @And("^Validate that the response  \"([^\"]*)\" must be \"([^\"]*)\"$")
    public void validateThatTheResponseMustBe(String message, String messageStatus) {
        createUserSteps.validateMessage(message, messageStatus);
    }


    //Service #2 Place an order for a pet


    @Given("^A user send the request to place an order for pet in the endpoint \"([^\"]*)\"$")
    public void aUserSendTheRequestToPlaceAnOrderForPetInTheEndpoint(String url, Map<String, String> body) {
        SerenityRest.given().baseUri(url).header("Content-Type","application/json").body(body).post();
        SerenityRest.lastResponse().then().log().all();
    }

    @Then("^Validate in the response that the status code is (\\d+)$")
    public void validateInTheResponseThatTheStatusCodeIs(int statusCode) {
        placeAnOrderSteps.validateStatusCode(statusCode);
    }

    @And("^Validate that the response body must be \"([^\"]*)\"$")
    public void validateThatTheResponseBodyMustBe(String structure) {
        placeAnOrderSteps.validateStructureService(structure);
    }


    @And("^Validate in the response that the response contains the key \"([^\"]*)\" must be \"([^\"]*)\"$")
    public void validateInTheResponseThatTheResponseContainsTheKeyMustBe(String status, String expectedStatus) {
        placeAnOrderSteps.validateStatusKey(status,expectedStatus);
    }




}
