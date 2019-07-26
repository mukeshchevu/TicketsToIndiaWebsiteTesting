package com.test.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import java.util.Date;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class CustomerDetails {
    @Before
    public static void setup(){
        RestAssured.baseURI = "https://reqres.in";
//
    }

    private String URL;
    private Response response;
    private JSONObject requestParams = new JSONObject();
    @Given("^I have API URL$")
    public void iHaveAPIURL() throws Throwable {
        URL = "api/users/2";
    }

    @When("^I call above get request API URL$")
    public void iCallAboveGetRequestAPIURL() throws Throwable {
        response = given().when().log().all().get(URL);
    }

    @Then("^Make sure response status code should return (\\d+)$")
    public void makeSureResponseStatusCodeShouldReturn(int statusCode) throws Throwable {
        Assert.assertEquals(response.getStatusCode(),statusCode );
        Assert.assertTrue(!response.getBody().asString().isEmpty());
        System.out.println(response.getBody().asString());
    }

    @And("^Verify that the response has first name Janet$")
    public void verifyThatTheResponseHasFirstNameJanet() throws Throwable {
        String firstname = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstname,"Janet");
        System.out.println("firstname:"+firstname);
    }

    @Given("^I have API URL  and request body$")
    public void iHaveAPIURLAndRequestBody() throws Throwable {
        RestAssured.baseURI = "http://restapi.demoqa.com/";
        URL="customer/register";

        requestParams.put("FirstName", "Rohith12"+new Date().getTime());
        requestParams.put("LastName", "reddy"+new Date().getTime());
        requestParams.put("UserName", "Rohith01"+new Date().getTime());
        requestParams.put("Password", "shetty123+new Date().getTime()");
        requestParams.put("Email",  "rohit1+"+new Date().getTime()+"+@gmail.com");
    }

    @When("^I call above post request$")
    public void iCallAbovePostRequest() throws Throwable {
        response=given().header("Content-Type", "application/json").log().all()
                .when().body(requestParams.toJSONString()).log().all().post(URL);
    }

    @Then("^Make sure post response status code should return (\\d+)$")
    public void makeSurePostResponseStatusCodeShouldReturn(int statusCode) throws Throwable {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }

    @And("^Verify the newly created user$")
    public void verifyTheNewlyCreatedUser() throws Throwable {
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals( "Correct Success code was not returned", successCode, "OPERATION_SUCCESS");
    }

    @Given("^I have API URL and existingdata$")
    public void iHaveAPIURLAndExistingdata() throws Throwable {
        URL="/api/users/2";
        requestParams.put("name","ramesh");
        requestParams.put("job","zion resident");
    }

    @When("^I call above put request$")
    public void iCallAbovePutRequest() throws Throwable {
        response=given().header("Content-Type", "application/json").log().all()
                .when().body(requestParams.toJSONString()).log().all().put(URL);
    }

    @Then("^Make sure get response status code should return (\\d+)$")
    public void makeSureGetResponseStatusCodeShouldReturn(int statusCode) throws Throwable {
        assertEquals(statusCode,response.getStatusCode());
    }


    @And("^Verify updated user$")
    public void verifyUpdatedUser() throws Throwable {
        String successCode = response.jsonPath().get("name");
        assertEquals( "Correct name was not returned", "ramesh",successCode );

    }
}