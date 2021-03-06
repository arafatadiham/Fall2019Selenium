package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    // p tag name of success message
   // Option 1 : ---->  private String firstNameLocator = "firstname";
                //---->   private String lastNameLocator = "lastname";
    // But , Option 2 : (Using By instead of String is more convenient)

    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");

    // following for XPATH
    // private By maleBy = By.xpath("//input[@value='male']");

    private By maleBy = By.cssSelector("input[value='male']"); // ---> CSS
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other");

    private By dateOfBirthBy= By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By cplusplusBy = By.xpath("//lable[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    //sign up button
    private By signUpBy = By.id("wooden_spoon");

    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123455678");
        driver.findElement(phoneBy).sendKeys("234-123-1231");

        driver.findElement(maleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/02/1940");

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @Test
    public void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}


/*
private String URL = "http://practice.cybertekschool.com/registration_form";
private WebDriver driver;
private WebElement successMessage = driver.findElement(By.xpath("//p"));
private WebElement firstNameElement = driver.findElement(By.name("firstname"));
private WebElement lastNameElement = driver.findElement(By.name("lastname"));
private WebElement userNameElement = driver.findElement(By.name("username"));
private WebElement emailElement = driver.findElement(By.name("email"));
private WebElement passwordElement = driver.findElement(By.name("password"));
private WebElement phoneElement = driver.findElement(By.name("phone"));
private WebElement genderMaleElement = driver.findElement(By.cssSelector("input[value='male']"));
private WebElement genderfemaleElement = driver.findElement(By.cssSelector("input[value='female']"));
private WebElement genderOtherElement = driver.findElement(By.cssSelector("input[value='other']"));
private WebElement birthdayElement = driver.findElement(By.name("birthday"));
private Select departmentSelect = new Select(driver.findElement(By.className("department")));
private Select job_titleSelect = new Select(driver.findElement(By.className("job_title")));
private WebElement progLangCPlusElement = driver.findElement(By.id("inlineCheckbox1"));
private WebElement progLangJavaElement = driver.findElement(By.id("inlineCheckbox2"));
private WebElement progLangJsElement = driver.findElement(By.id("inlineCheckbox3"));
private WebElement submitBtnElement = driver.findElement(By.id("wooden_spoon"));
 */