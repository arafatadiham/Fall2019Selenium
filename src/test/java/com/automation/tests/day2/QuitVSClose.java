package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVSClose {

    public static void main(String[] args) throws Exception {

        // ---> Quit basicly will close all windows (tabs) that you opened on the web-browser
        // ---? Close is just close only one window that you run.

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        driver.close();

    }
}
