package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TicketsToIndiaResultsPage extends WebdriverUtils{

    private WebDriver driver;

    public TicketsToIndiaResultsPage(WebDriver driver)
    {
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void stopsSelection(){
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        WebElement element=webDriverWait.until(ExpectedConditions.elementToBeClickable (getElement(By.xpath("//input[@id='chkstop_2']"))));
        element.click();
    }

    public int resultsSize(){

       List<WebElement> resultsList=getElements(By.className("trip-bound"));
        return resultsList.size();
    }
}