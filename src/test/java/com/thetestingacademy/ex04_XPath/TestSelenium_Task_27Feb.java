package com.thetestingacademy.ex04_XPath;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium_Task_27Feb {

    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify funds transfer")
    @Test
    public void Test_TTA_Bank() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");

        Thread.sleep(2000);

        Allure.step("Signup");
        WebElement signup = driver.findElement(By.xpath("//button[contains(text(),\"Sign Up\")]"));
        signup.click();

        Thread.sleep(2000);

        WebElement fullname = driver.findElement(By.xpath("//input[@placeholder=\"John Doe\"]"));
        fullname.sendKeys("Test Two");

        WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        email.sendKeys("test2@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.sendKeys("test123");

        WebElement create_account = driver.findElement(By.xpath("//button[contains(text(),\"Create\")]"));
        create_account.click();

        Thread.sleep(3000);

        Allure.step("Navigate to Dashboard");
        WebElement h1 = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(h1.getText(),"Dashboard");
        if(h1.getText().equals("Dashboard"))
        {
            System.out.println("Signup Passed");
        }
        else {
            System.out.println("Signup Failed");
        }

        Allure.step("Navigate to Transfer Funds");
        WebElement transfer_funds = driver.findElement(By.xpath("//button[contains(text(),\"Transfer Funds\")]"));
        transfer_funds.click();

        Thread.sleep(2000);

        Allure.step("Transfer the amount 5000");
        WebElement amount = driver.findElement(By.xpath("//input[@type=\"number\"]"));
        amount.sendKeys("5000");

        WebElement btn_continue = driver.findElement(By.xpath("//button[contains(text(),\"Continue\")]"));
        btn_continue.click();

        Thread.sleep(3000);

        WebElement review_transfer = driver.findElement(By.xpath("//h3[contains(text(),\"Review\")]"));
        Assert.assertEquals(review_transfer.getText(),"Review Transfer");

        if(review_transfer.getText().equals("Review Transfer")){
            System.out.println("Confirm page displayed");
        }
        else {
            System.out.println("confirm page not displayed");
        }

        WebElement btn_confirm = driver.findElement(By.xpath("//button[contains(text(),\"Confirm\")]"));
        btn_confirm.click();

        Thread.sleep(3000);

        Allure.step("Navigate back to Dashboard");
        WebElement dashboard = driver.findElement(By.xpath("//button[contains(text(),\"Dashboard\")]"));
        dashboard.click();

        Thread.sleep(2000);

        Assert.assertEquals(h1.getText(),"Dashboard");

        Allure.step("Verify total balance");
        WebElement total_bal = driver.findElement(By.xpath("//h3[@class=\"mt-2 text-3xl font-bold\"]"));
        Assert.assertEquals(total_bal.getText(),"$45,000.00");

        if(total_bal.getText().equals("$45,000.00")){
            System.out.println("Funds Transfer Success");
        }
        else{
            System.out.println("Funds Transfer Failed");
        }

        driver.quit();
    }
}
