package com.thetestingacademy.ex09_Input_Select_Alerts_Radio;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium_JS_Alerts extends CommonToAll {

    @Test
    public void test_Alerts(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));

        WebElement elementConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));

        WebElement elementPrompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));

        element.click();

        //first we have to wait for the alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,"You successfully clicked an alert");

        elementConfirm.click();

        waitForAlert(driver,10);

        Alert alertCancel=driver.switchTo().alert();
        alertCancel.dismiss();

        String result1 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result1,"You clicked: Cancel");

        elementConfirm.click();

        waitForAlert(driver,15);

        Alert alertOk=driver.switchTo().alert();
        alertOk.accept();

        String result2 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result2,"You clicked: Ok");

        elementPrompt.click();

        waitForAlert(driver,20);

        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("Vani");
        alert1.accept();

        String result3 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result3,"You entered: Vani");

        closeBrowser(driver);
    }
}
