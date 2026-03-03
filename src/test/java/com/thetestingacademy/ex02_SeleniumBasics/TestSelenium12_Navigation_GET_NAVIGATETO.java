package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium12_Navigation_GET_NAVIGATETO {

    @Test
    public void test_selenium_12(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //get and navigate both are same
        //but with navigate we can also use extra functions like back, refresh and forward

        driver.navigate().to("https://bing.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();
    }
}
