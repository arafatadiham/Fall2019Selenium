package com.automation.tests.day14;

public class ClassNote_March28 {

    /*

    March 28, 2020
    Agenda:
        - Test base class
        - Page Object Model
        - Page Factory
#################################################################
Implicit wait doesn't get along with Explicit wait. If you gonna use them in the same test, it might cause unexpectedly long delays.
If we would use implicit wait - it would go into @BeforeMethod.
Explicit wait - used inside a test itself, since we have to provide a webelement, unless @BeforeMethod use some kind of WebElements.
Test base - abstract class that is used as a basement for all test classes. This class provides minimum essential setup and cleanup for every test of our project. Class is abstract because has to be extended. Doesn't contain tests itself. In this class, we initialize WebDriverWait, Actions class objects and open the browser. Should be stored under tests package or some kind of base package. But not under utilities package. We can also add @Before/After test,class, suit methods if needed.
package com.automation.tests.vytrack;
/*

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public abstract class TestBase {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
}
It's a blueprint for all test classes.
pages package - used to store a collection of page classes.
 /**
   * As {@link org.openqa.selenium.support.PageFactory#initElements(org.openqa.selenium.WebDriver,
   * Class)} but will only replace the fields of an already instantiated Page Object.
   *
   * @param driver The driver that will be used to look up the elements
   * @param page   The object with WebElement and List&lt;WebElement&gt; fields that
   *               should be proxied.
   */

    /*

package com.automation.pages;
import com.automation.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
    public class LoginPage {
        public LoginPage(){
            //to connect our webdriver, page class and page factory
            //PageFactory - used to use @FindBy annotations
            //PageFactory - helps to find elements easier
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }
    FindAll==>or
    FindBys==>and
    According to Page Object Model, we should keep our tests and element locators separately, this will keep code clean and easy to understand and maintain.
    The Page Object approach makes test automation framework programmer friendly, more durable and comprehensive.
    Another important advantage is our Page Object Repository is Independent of Automation Tests. Keeping separate repository for page objects helps us to use this repository for different purposes with different frameworks like, we are able to integrate this repository with other tools like JUnit as well as with TestNG/Cucumber/etc.
    Test cases become short and optimized as we are able to reuse page object methods in the POM classes.
    Any change in UI can easily be implemented, updated and maintained into the Page Objects and Classes.
    PageFactory - used to improve page object model. It helps to find webelements with @FindBy, @FindBys, @FindAll
    pages
            AbstractPageBase
    LoginPage
            VehiclesPage
    tests
            AbstractTestBase
    LoginTests
            VehiclesTests
    utilities
            BrowserUtilities
    ConfigurationReader
            Driver
    DateTimeUtilities *optional
    StringUtilities   *optional
    DataBaseUtilities *optional
    AbstractPageBase - works as basement for all/most of the page class
         - Contains common element/locators
         - Initializes page factory --> to use @FindBy in all sub-classes
    AbstractTestBase - works as a basement for all test classes.
         - contains @Before and @After methods, no tests at all
         - opens browser
         - closes browser
    Why they are Abstract?
            - because, they have to be extended. If class is abstract, it must be extended, otherwise you cannot use it.
    Why WebElement are private in page classes?
            - so there is no way to use the directly in the tests. We have to separate page logic from the test. Otherwise, we will have too much logic in the test classes. test classes, are not responsible for find element and their interaction. It's a role of page classes.  In test classes, we just create a page objects and call methods to interact with page to perform testing. Also, we use assertions in the test classes.

*/

    }
