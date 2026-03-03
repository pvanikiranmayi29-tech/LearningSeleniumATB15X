package com.thetestingacademy.ex03_Locators;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_Task25Feb {
    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("//Jira Link")
    @Description("Verify that error message comes with invalid email on signup")
    @Test
    public void test_make_appointment() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement a_tag_make_appointment = driver.findElement(By.partialLinkText("Appointment"));
        a_tag_make_appointment.click();

        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement passowrd = driver.findElement(By.id("txt-password"));
        passowrd.sendKeys("ThisIsNotAPassword");

        Allure.step("Clicking on Login");
        WebElement login_btn = driver.findElement(By.id("btn-login"));
        login_btn.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("appointment")) {
            System.out.println(driver.getCurrentUrl());
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }

        Allure.step("Navigate to Make Appointment Screen");
        List<WebElement> elements = driver.findElements(
                By.xpath("//h2[text()='Make Appointment']")
        );

        if (elements.size() > 0) {
            System.out.println("Make Appointment is present");
        } else {
            System.out.println("Make Appointment is NOT present");
        }

        driver.quit();
    }
}
