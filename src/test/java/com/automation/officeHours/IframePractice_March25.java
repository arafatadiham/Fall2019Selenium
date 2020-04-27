package com.automation.officeHours;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class IframePractice_March25 {

  WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws Exception {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        Thread.sleep(2000);
        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */

        for (int i = 0; i<frameList.size(); i++) {
            driver.switchTo().frame(i);
            String bodyText = driver.findElement(By.xpath("//body")).getText();
            System.out.println("bodyText = " + bodyText);
            driver.switchTo().parentFrame();
        }

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Body text: " + bodyText);

        driver.switchTo().defaultContent();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}