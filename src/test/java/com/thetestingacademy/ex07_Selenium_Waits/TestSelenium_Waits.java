package com.thetestingacademy.ex07_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium_Waits {

    @Test
    public void test_verify_print_imac_price(){

        //There are three types of waits in Selenium
        //Implicit Wait, Explicit Wait, Fluent Wait

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://app.vwo.com");

        //The problem with implicit wait is that
        //the webdriver will wait for each element to load
        //for each element it will wait for 20 sec
        //that means in this case it will wait for 3*20 = 60 sec
        //and then if any webelement is not found then it throws the exception

        //this implicit wait is not practical and will not be used in selenium
        //it is not a best practice

        WebElement email_InputBox = driver.findElement(By.id("login-username"));
        email_InputBox.sendKeys("admin@admin.com");

        WebElement password_InputBox = driver.findElement(By.name("password"));
        password_InputBox.sendKeys("password@321");

        WebElement submit_button = driver.findElement(By.id("js-login-btn"));
        submit_button.click();

        driver.quit();
    }
}
