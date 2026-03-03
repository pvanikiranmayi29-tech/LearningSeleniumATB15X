package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium10_TestNG_Example {

    @Test
    public void test_Selenium_App_VWO(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        Assert.assertEquals(driver.getTitle(),"Login - VWO");
        driver.close();
    }
}
