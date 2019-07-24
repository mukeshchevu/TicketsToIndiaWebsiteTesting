package com.test.stepdefs;
import com.fasterxml.jackson.databind.util.JSONPObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class RestAssuredPost {

    RequestSpecification request = RestAssured.given();


    static{
        RestAssured.baseURI = "http://restapi.demoqa.com/";
    }

    private String URL;
    private Response response;
    private JSONObject requestParams = new JSONObject();


    @Given("^i have API URL  and request body$")
    public void iHaveAPIURLAndRequestBody() throws Throwable {
       URL="customer/register";

        requestParams.put("FirstName", "Rohith12");
        requestParams.put("LastName", "reddy");
        requestParams.put("UserName", "Rohith01");
        requestParams.put("Password", "shetty123");
        requestParams.put("Email",  "rohit1@gmail.com");
    }

    @When("^i call above post request$")
    public void iCallAbovePostRequest() throws Throwable {
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
        response = request.post(URL);
    }

    @Then("^make sure post response status code should return (\\d+)$")
    public void makeSurePostResponseStatusCodeShouldReturn(int HTTPcode) throws Throwable {
        Assert.assertEquals(HTTPcode,response.getStatusCode());
    }

    @And("^verify the newly created user$")
    public void verifyTheNewlyCreatedUser() throws Throwable {
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was not returned", successCode, "OPERATION_SUCCESS");
    }

}

