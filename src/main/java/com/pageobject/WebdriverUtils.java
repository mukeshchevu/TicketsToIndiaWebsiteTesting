package com.pageobject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WebdriverUtils {
    private static WebDriver driver;
    public static WebDriver getWebdriver()
    {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
         driver = new ChromeDriver();

        return driver;
    }

    public void selectByVisibleText(By by,String value){

        Select oselect = new Select(getElement(by));
        oselect.selectByVisibleText(value);
    }

    public WebElement getElement(By by)
    {
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by)
    {
        return driver.findElements(by);
    }

    public void getScrennshot()
    {
        DateFormat df=new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
        Date d=new Date();
        String datef=df.format(d);
        File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File ("E://ScreenShot/Screens/"+datef+"SearchPage.png"));
        } catch (IOException t){}
    }
}
