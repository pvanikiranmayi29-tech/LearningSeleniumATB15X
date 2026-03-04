package com.thetestingacademy.ex04_XPath;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium20_MiniProject {
    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Login is working")
    @Test
    public void test_OHRM_Login() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(2000);
        //Xpath is found by using //tagname[@attribute="value"]
        //on the inspect element page - do a ctrl+F and we can type the xpath there and find no. of matches
        //here we can give xpath as "//*[@name=\"username\"]"
        //where * is a wild charc
        //but //input[@name="username"] this xpath is more specific and efficient
        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        username.sendKeys("admin");

        //for password we can also give xpath as //input[@name="password"]
        //while giving xpath if we use "" for the value then we need to add the escape char\
        //if we use '' - escape char is not required
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Hacker@4321");

        //when only one button is there we can use
        // only //button

        WebElement login_button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        login_button.click();

        Thread.sleep(3000);

        Allure.step("Verify Login Success");
        WebElement h6 = driver.findElement(By.xpath("//span[@class=\"oxd-topbar-header-breadcrumb\"]/h6"));
        Assert.assertEquals(h6.getText(),"PIM");

        //System.out.println(h6.getText());

                if(h6.getText().equals("PIM")){
                    System.out.println("Login Successful");
                }
                else {
                    System.out.println("Login Unsuccessful");
                }
        driver.quit();
    }
}
