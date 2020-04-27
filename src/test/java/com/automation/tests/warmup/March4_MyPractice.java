package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class March4_MyPractice {

       static WebDriver driver;

    public static void main(String[] args) throws Exception {


        //ebay();
        //amazon();
        wiki();
    }

    /**
     * Go to ebay --->          driver.get("http://ebay.com");
     * enter search term        input.sendKeys("java book");
     * click on search button   searchButton.click();
     * print number of results
     */
    public static void ebay() throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        Thread.sleep(2000);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        WebElement searchResult= driver.findElement(By.tagName("h1"));
        String [] searchSectence = searchResult.getText().split(" ");
        System.out.println(Arrays.toString(searchSectence));
        System.out.println(searchSectence[0]);
        driver.close();

    }

    /**
     * go to amazon
     * enter search term
     * click on search button
     * verify title contains search term
     */
    public static void amazon () throws Exception{

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);//just to see the full title
        if(title.contains("java book")){
            System.out.println("Test passed");
        } else {
            System.out.println("test Failed");
        }
        driver.quit();
    }

    /**
     * Go to wikipedia.org
     * enter search term `selenium webdriver`
     * click on search button
     * click on search result `Selenium (software)`
     * verify url ends with `Selenium_(software)`
     */
    public static void wiki () throws Exception {

        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String currentURL = driver.getCurrentUrl();
        if (currentURL.endsWith("Selenium_(software)")) {
            System.out.println("Test passed");
        } else {
            System.out.println("test Failed");
        }
        driver.quit();
    }
}
