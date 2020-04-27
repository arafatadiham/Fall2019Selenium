package com.automation.tests.day7_March10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath_Important{

    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
   // public static String loginBtnLocator = "//button[contains(text(), 'Login')];


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(userNameLocator)).sendKeys("Alden");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("topsecret");
        BrowserUtils.wait(3);
        driver.quit();
    }
}
