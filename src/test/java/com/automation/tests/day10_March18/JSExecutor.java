package com.automation.tests.day10_March18;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
Why do we need JavaScriptExecutor?
In Selenium Webdriver, locators like XPath, CSS, etc.
are used to identify and perform operations on a web page.
In case, these locators do not work you can use JavaScriptExecutor.
You can use JavaScriptExecutor to perform an desired operation on a web element.
 */

public class JSExecutor {
    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
//        driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
//        you need to cast if reference type is a WebDriver
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
//        x, y offset
        for (int i=0; i < 10; i++){
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(3);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
    }


}

/*

//how to use javaScriptExecutor?
//javaScriptExecutor; it is an interface we can not create object out of it.
//But javascript executor and webDriver are like siblings
//So we will cast driver to JavascriptExecutor
//we convert webDriver object into JavaScriptExecutor
//JavascriptExecutor js = (JavascriptExecutor) driver;
//interface => they don't have implementation
//if you have interface as reference type you can see methods only coming from that interface
//you can not see other methods that are in other interfaces
//so we will use remoteWebDriver class as reference type :
//if you use remoteWebDriver class as reference type you do not need to cast anymore, it has everything
//like this => private RemoteWebDriver driver;
//driver.executeScript("window.scrollBy(0, 250)");
//you need to cast if your reference type is webDriver; like this =>  private WebDriver driver;
//JavascriptExecutor js = (JavascriptExecutor) driver;
 */