package com.thetestingacademy.ex03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium15 {

    @Test
    public void test_app_vwo_com() throws InterruptedException {
        //there are 3 imp components in selenium
        //Driver



        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        //Locator
        //while finding locators we have preference rules
        //unique ID -> name -> class Name -> TagName -> Link Text/Partial(a tag) ->CSS Selector -> XPATH

        WebElement email_input_box = driver.findElement(By.id("login-username"));
        email_input_box.sendKeys("admin@admin.com");

        WebElement password_input_box = driver.findElement(By.name("password"));
        password_input_box.sendKeys("wrongpass@123");

        WebElement button_submit = driver.findElement(By.id("js-login-btn"));
        button_submit.click();

        //we need to wait for error to appear
        Thread.sleep(5000);

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        //System.out.println(error_message.getText());
        String err_msg = error_message.getText();
        System.out.println(err_msg);


        //Assertion
        // error_message - AR
        // "Your email, password, IP address or location did not match" - ER

        Assert.assertEquals(err_msg,"Your email, password, IP address or location did not match");

        //we have installed the allure testng reports
        //no configuration needed
        //we need to create the testng xml file

        driver.quit();

    }
}
