package com.automation.tests.day8_March14_Saturday;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // Runs only once before @beforeMethod and before any test
    @BeforeClass
    public void beforeClass(){

        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    //runs before every test automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

    @Test
    public void test1() {
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        //it calls hard assertion.
        //if assertion fails - it stops the execution (due to exception).
        Assert.assertTrue(num1 < num2);
    }
}