package com.thetestingacademy.ex03_Locators;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestSelenium17_Mini_Project2_Signup_NTC {

    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("//Jira Link")
    @Description("Verify that error message comes with invalid email on signup")
    @Test
    public void test_vwo_free_trail_error_Verify() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        String parentWindow = driver.getWindowHandle();

        WebElement a_partial_match = driver.findElement(By.partialLinkText("trial"));
        a_partial_match.click();

        Thread.sleep(10000);

        Set<String> allWindows = driver.getWindowHandles();

        //System.out.println(parentWindow);

        //System.out.println(allWindows);

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println("Title of new window: " + driver.getTitle());

        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        Allure.step("Clicking on free trail");
        WebElement email_signup = driver.findElement(By.id("page-v1-step1-email"));
        email_signup.sendKeys("abc");

        WebElement consent_check_box = driver.findElement(By.name("gdpr_consent_checkbox"));
        consent_check_box.click();

        //tagname will give us list of same elements on page
        //but the first element will be considered when trying to click
        WebElement button_create_account = driver.findElement(By.tagName("button"));
        button_create_account.click();

        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");

        driver.quit();
    }
}
