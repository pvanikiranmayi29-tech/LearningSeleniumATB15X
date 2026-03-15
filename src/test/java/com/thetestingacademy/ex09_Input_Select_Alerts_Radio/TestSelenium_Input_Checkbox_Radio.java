package com.thetestingacademy.ex09_Input_Select_Alerts_Radio;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Allure;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestSelenium_Input_Checkbox_Radio extends CommonToAll {

    @Test
    public void test_select(){

        //select is a kind of dropdown in java
        //for dropdowns - we have 2 types of dropdowns
        //static - which is static in nature and created with <select> tag
        //dynamic - which is created by using <ul>/<div> tags

        //lets work on static
        WebDriver driver = new ChromeDriver();
        openBrowser(driver,"https://katalon-demo-cura.herokuapp.com/");

        WebElement a_tag_make_appointment = driver.findElement(By.partialLinkText("Appointment"));
        a_tag_make_appointment.click();

        waitforJVM(3000);

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement passowrd = driver.findElement(By.id("txt-password"));
        passowrd.sendKeys("ThisIsNotAPassword");

        Allure.step("Clicking on Login");
        WebElement login_btn = driver.findElement(By.id("btn-login"));
        login_btn.click();

        waitforJVM(5000);
        //we are using explicit wait to wait for the alert to appear
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());*/

        //we need to switch to the alert
        /*Alert alert = driver.switchTo().alert();
        //and we can click ok
        alert.accept();

        if(alert.getText().contains("Change")){
            System.out.println("alert is displayed");
        }
        else {
            System.out.println("alert is not displayed");
        }*/

        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false); // This is the key preference

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);


        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        waitforJVM(3000);

        Allure.step("Navigate to Make Appointment Screen");
        waitForVisibility(driver,"//h2[text()='Make Appointment']");

        WebElement element = driver.findElement(By.id("combo_facility"));
        Select select = new Select(element);
        select.selectByVisibleText("Hongkong CURA Healthcare Center");


        waitforJVM(4000);
        closeBrowser(driver);
    }
}
