package com.test.stepdefs;

import com.pageobject.TicketsToIndiaResultsPage;
import com.pageobject.TicketsToIndiaSearchPage;
import com.pageobject.WebdriverUtils;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketsToIndia extends WebdriverUtils  {

    private WebDriver driver;
    private TicketsToIndiaSearchPage ticketsToIndiaSearchPage;
    private TicketsToIndiaResultsPage ticketsToIndiaResultsPage;

    @Before
    public void TicketsToIndia(){
        driver= WebdriverUtils.getWebdriver();
        ticketsToIndiaSearchPage = new TicketsToIndiaSearchPage(driver);
        ticketsToIndiaResultsPage=new TicketsToIndiaResultsPage(driver);
    }

    @Given("^i am in home page \"([^\"]*)\"$")
    public void iAmInHomePage(String URL) throws Throwable {
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @When("^i enter destination details$")
    public void iEnterDestinationDetails(DataTable DetailsOfTicketsToIndia) throws Throwable {
       List<Map<String,String>> dataList= DetailsOfTicketsToIndia.asMaps(String.class,String.class);
        Map<String, String> detailsMap = new HashMap<String,String>();
            detailsMap.put("flyFrom",dataList.get(0).get("flyFrom"));
            detailsMap.put("flyTo",dataList.get(0).get("flyTo"));
        detailsMap.put("noOfAdults",dataList.get(0).get("noOfAdults"));
        detailsMap.put("noOfChildren",dataList.get(0).get("noOfChildren"));
        detailsMap.put("noOfInfants",dataList.get(0).get("noOfInfants"));
        detailsMap.put("classType",dataList.get(0).get("classType"));
        ticketsToIndiaSearchPage.enteringDetails(detailsMap);

    }

    @And("^click search button$")
    public void clickSearchButton() throws Throwable {
        ticketsToIndiaSearchPage.searchButton();
    }

    @Then("^results should get displayed$")
    public void resultsShouldGetDisplayed() throws Throwable {
        Assert.assertTrue(ticketsToIndiaResultsPage.resultsSize()>0);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}