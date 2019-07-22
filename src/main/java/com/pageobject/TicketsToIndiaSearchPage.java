package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TicketsToIndiaSearchPage extends WebdriverUtils{

    Select oselect;
    private WebDriver driver;
    private static By flyFrom = By.name("FDestFrom");
    private static By flyTo=By.name("FDestTo");
    private static By noOfAdults=By.name("FAdult");
    private static By noOfChildren=By.name("FChild");
    private static By noOfInfants=By.name("FInfant");
    private static By classType=By.name("FClsType");


    public TicketsToIndiaSearchPage(WebDriver driver)
    {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void enteringDetails(Map<String,String> detailsMap)
    {
        getElement(By.name("FDestFrom")).sendKeys(detailsMap.get("flyFrom"));
        getElement(By.name("FDestTo")).sendKeys(detailsMap.get("flyTo"));
        getElement(By.cssSelector("li.ac_even")).click();
        // driver.findElement(By.id("FDptDateDDMMYY")).setAttribute("FDptDateDDMMYY", "departureDate");
        // driver.findElement(By.name("FDptDateDDMMYY")).sendKeys(detailsMap.get("departureDate"));
        // driver.findElement(By.name("FRetDateDDMMYY")).sendKeys(detailsMap.get("returnDate"));
        selectByVisibleText(By.name("FAdult"),detailsMap.get("noOfAdults"));
        selectByVisibleText(By.name("FChild"),detailsMap.get("noOfChildren"));
        selectByVisibleText(By.name("FInfant"),detailsMap.get("noOfInfants"));
        selectByVisibleText(By.name("FClsType"),detailsMap.get("classType"));

    }
    public void searchButton(){
        getElement(By.xpath("//a[@id='imgSearch12']")).click();
    }
}