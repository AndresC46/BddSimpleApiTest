package com.locoman.apitest;

import com.locoman.apitest.Drivers.ReadConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class RestApiTestSteps {
    String sutBaseUrl = ""; // Set sutUrl
    String endPoint = "";
    Response response;
    Logger logger = LoggerFactory.getLogger("BDD_Logger");
    ReadConfig readConfig;

    @Given("a {string} simpleAPI")
    public void aSimpleAPI(String environment) {
        readConfig = new ReadConfig(logger, environment);
        sutBaseUrl = readConfig.getConfiguration("BaseUrl"); // Set sutUrl
    }


    @When("I make a GET API request for {string}")
    public void iMakeAGETAPIRequestFor(String domainType) {
        endPoint = sutBaseUrl + readConfig.getConfiguration(domainType);
        logger.info("REST Endpoint is : "+ endPoint);
        response = RestAssured.get(endPoint);
    }

    @Then("the response status code is {string}")
    public void theResponseStatusCodeIs(String statusCode) {
        int code = Integer.parseInt(statusCode);
        logger.info("Response status code is : "+ code);
        assertThat(response.getStatusCode()).isEqualTo(code);
    }

    @And("the response data is an empty set")
    public void theResponseDataIsAnEmptySet() {
        logger.info("Response Body: " + response.getBody() );
        assertThat(response.getBody()).isNull();
    }


}
