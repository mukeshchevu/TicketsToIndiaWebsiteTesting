package com.test.stepdefs;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class RestAssuredGet {

    static{
        RestAssured.baseURI = "https://reqres.in";
    }

    private String URL;
    private Response response;

    @Given("^i have API URL$")
    public void iHaveAPIURL() throws Throwable {

        URL = "api/users/2";
    }

    @When("^i call above get request API URL$")
    public void iCallAboveGetRequestAPIURL() throws Throwable {
         response = given()
                .get(URL);
    }

    @Then("^make sure response status code should return (\\d+)$")
    public void makeSureResponseStatusCodeShouldReturn(int HTTPCode) throws Throwable {
        Assert.assertEquals(response.getStatusCode(),HTTPCode );
        Assert.assertTrue(!response.getBody().asString().isEmpty());
        System.out.println(response.getBody().asString());
    }

    @And("^verify that the response has first name Janet$")
    public void verifyThatTheResponseHasFirstNameJanet() throws Throwable {

        String firstname = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstname,"Janet");
        System.out.println("firstname:"+firstname);

    }


}
