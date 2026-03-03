package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_Assertion_TestNG {
    //while using testng - we dont need to write the main method
    //this is taken care by the testng

    //we need to make sure that the java program starts with test
    //and also the class that we want to executes starts with test

    //and we need to add the annotation @Test

    @Test
    public void test_selenium_01(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        //TestNG
        //assert will verify the Actual result with the expected result
        //Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
        Assert.assertEquals(driver.getTitle(),"Google");

        //AssertJ
        assertThat(driver.getTitle())
                .isNotBlank()
                .isNotEmpty()
                .isNotNull()
                .isEqualTo("Google");
        //we can do multiple assertions in one go

        driver.close();
    }
}
