package com.automation.officeHours;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class VYTrackPractice_March17 {

    private WebDriver driver;
    private String url="https://qa3.vytrack.com/user/login";
    private String username = "storemanager85";   //   valid username
    private String password = "UserUser123";      //   valid password
    private By usernameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By clickLogin=By.id("_submit");
    @BeforeMethod
    protected void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    protected void login(){
        driver.get(url);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(clickLogin).submit();
    }
    @Test
    protected void createContact() throws InterruptedException {

        login();
        BrowserUtils.wait(5);
        WebElement contactLink=driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        contactLink.click();
        BrowserUtils.wait(5);
        WebElement creatingContact=driver.findElement(By.linkText("Create Contact"));
        creatingContact.click();
        BrowserUtils.wait(5);
        String currentTitle=driver.getTitle();
        Assert.assertEquals(currentTitle,"Create Contact - Contacts - Customers");

        HashMap<String,String> contact1= new HashMap<>();
        contact1.put("First Name","John");
        contact1.put("Last Name","Smith");
        contact1.put("Phone", "571-236-4545");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");

        System.out.println("Contact 1: " + contact1);

        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name='field__first-name'])[1]"));
        WebElement last_name= driver.findElement(By.xpath("(//input[@data-name='field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][city]"));
        WebElement state = driver.findElement(By.name("oro_contact_form[addresses][0][region_text]"));
        WebElement zipCode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("(//input[@data-name='field__1'])[2]"));


        first_name.sendKeys(contact1.get("First Name"));
        last_name.sendKeys(contact1.get("Last Name"));
        phone.sendKeys(contact1.get("Phone"));
        street.sendKeys(contact1.get("Street"));
        city.sendKeys(contact1.get("City"));
        state.sendKeys(contact1.get("State"));
        zipCode.sendKeys(contact1.get("Zip Code"));



        /*

        To handle dropdown in selenium we are using Select class;
        to use it we have to ensure we have <select></select> tag in our dropdown

         */

        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdown = new Select(country);// this is the special class to handle dropdown in selenium
        /*
        it has different methods that help us interact with dropdown
         */
        country_dropdown.selectByVisibleText(contact1.get("Country"));

        if (contact1.get("Sales Group").equalsIgnoreCase("true")){
            salesGroup.click();
        }

        driver.findElement(By.xpath("(//button[contains(text(), 'Save and Close')])[1]")).click();
        Thread.sleep(3000);
        String fullName = contact1.get("First Name") + " " + contact1.get("Last Name");
        String uiFullName = driver.findElement(By.xpath("//h1[@class='user-name']")).getText();
        Assert.assertEquals(uiFullName, fullName);
        System.out.println("Actual: " + uiFullName + " | Expected: " + fullName);

        String uiPhone = driver.findElement(By.className("phone")).getText();
        Assert.assertEquals(uiPhone, contact1.get("Phone"));
        System.out.println("Actual: " + uiPhone + " | Expected: " + contact1.get("Phone"));
        Thread.sleep(2000);
        String uiCompleteAddress = driver.findElement(By.xpath("//address")).getText();
        String cityWithState = (contact1.get("City") + " " + contact1.get("State") +
                " " + contact1.get("Country") + " " + contact1.get("Zip Code")).toUpperCase();
        String completeAddress = contact1.get("Street") + "\n" + cityWithState;
        Assert.assertEquals(uiCompleteAddress, completeAddress);
    }

}


