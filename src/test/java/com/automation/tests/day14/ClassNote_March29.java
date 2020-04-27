package com.automation.tests.day14;

public class ClassNote_March29 {

    /*

    Today is March 29, 2020
    Agenda:
        Page
        Object
        Model
#######################
/**
 * Test Case: Default options
 * Login as sales manager
 * Go to Activities --> Calendar Events
 * Click on Create Calendar Event
 * Default owner name should be current user/
 why we put current user element under base page class and owner element under create calendar event page class?
"current owner" element belongs to the top menu. Top menu  ( or navigation menu) doesn't belong to particular page. Since top menu elements are shared, we can store them in the base page class.
object repository - pages package --> where is your page classes --> from page classes you create page objects
When test fails, for example over synchronization issues, you shouldn't add some waits into test itself (preferably). You should add/increase wait time in the page classes.
::::use qa1::::
Test Case: Verify calendar events table
Login as store manager
Go to Activities --> Calendar Events
And verify that column names displayed:
|TITLE            |
|CALENDAR         |
|START            |
|END              |
|RECURRENT        |
|RECURRENCE       |
|INVITATION STATUS|
package com.automation.tests.vytrack.activities;
import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
public class NewCalendarEventsTests extends AbstractTestBase {
    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user/
     **/

    /*
    @Test
    public void defaultOptionsTest() {
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());
        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getCurrentDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
    }
    /**
     * 35 minutes until 4:05
     * Test Case: Time difference
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Verify that difference between start and end time is 1 hour
     **/

    /*


    @Test
    public void timeDifferenceTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        String startTime = calendarEventsPage.getStartTime(); //get start time
        String endTime = calendarEventsPage.getEndTime(); //get end time
        String format = "h:mm a";//format 5:15 AM for example
        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);
        Assert.assertEquals(actual, 1, "Time difference is not correct");
    }
    /**
     * Test Case: Verify calendar events table
     * Login as store manager
     * Go to Activities --> Calendar Events
     * And verify that column names displayed:
     * |TITLE            |
     * |CALENDAR         |
     * |START            |
     * |END              |
     * |RECURRENT        |
     * |RECURRENCE       |
     * |INVITATION STATUS|
     */
    /*



    @Test
    public void verifyColumnNamesTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calendarEventsPage.getColumnNames(), expected);
    }
}

*/

 }