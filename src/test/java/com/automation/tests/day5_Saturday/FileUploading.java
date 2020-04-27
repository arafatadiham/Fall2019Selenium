package com.automation.tests.day5_Saturday;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

        WebElement upload = driver.findElement(By.id("file-upload"));
        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";// for every computer path is different
        String file2 = "/Users/mac/Desktop/Screen Shot 2020-03-02 at 6.13.14 PM.png";

        upload.sendKeys(filePath);
        //upload.sendKeys(file2);

        driver.findElement(By.id("file-submit")).click();//click to upload
        BrowserUtils.wait(5);
        driver.quit();

    }
}
