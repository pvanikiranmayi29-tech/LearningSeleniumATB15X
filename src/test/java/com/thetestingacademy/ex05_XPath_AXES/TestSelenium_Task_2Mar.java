package com.thetestingacademy.ex05_XPath_AXES;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_Task_2Mar {

    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Find the first terminated employee from the table")
    @Test
    public void test_orangehrm_term_emp() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.xpath("//input[@name=\"username\"]"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Hacker@4321");

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

        //to find the rows we can use the xpath in 2 ways
        // 1. //div[@role="table"]/div[@class="oxd-table-body"]/div[@class="oxd-table-card"]
        // 2. //div[@class="oxd-table-card"]

        // dar - //div[@class="oxd-table-card"][3]/div[@role="row"]/div[@role="cell"]

        String first_part = "//div[@class=\"oxd-table-card\"][";
        //i=rows
        String second_part="]/div[@role=\"row\"]/div[@role=\"cell\"][";
        //j=cols
        String third_part = "]";

        Allure.step("Find the table rows and cols");
        List<WebElement> row_xpath = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]"));

        int rows = row_xpath.size();

        List<WebElement> col_path = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"][3]/div[@role=\"row\"]/div[@role=\"cell\"]"));

        int cols = col_path.size();

        Allure.step("Traverse between the rows and cols");
        outerloop:
        for (int i = 1; i <=rows; i++) {
            for (int j = 1; j <=cols; j++) {
                String dynamic_xpath = first_part+i+second_part+j+third_part;
                //System.out.println(dynamic_xpath);

                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                //String add = "[3]/div/button/i";
                String add = "/div/button/i";


                if(data.equals("Terminated")){
                    Allure.step("Find the first terminated employee");
                    //String actions_path = dynamic_xpath+"/following-sibling::div"+add;
                    //driver.findElement(By.xpath(actions_path)).click();

                    String actions_path = first_part+i+second_part+cols+third_part+add;
                    Allure.step("Click on Delete");
                    System.out.println(actions_path);
                    driver.findElement(By.xpath(actions_path)).click();
                    Thread.sleep(2000);

                    WebElement are_you_sure = driver.findElement(By.xpath("//div[@class=\"orangehrm-modal-header\"]"));
                    System.out.println(are_you_sure.getText());

                    Allure.step("Verify the delete pop-up displayed");
                    Assert.assertEquals(are_you_sure.getText(),"Are you Sure?");

                    if(are_you_sure.getText().contains("Are you Sure?")){
                        System.out.println("Delete pop-up displayed");
                    }
                    else {
                        System.out.println("Delete not clicked");
                    }
                    break outerloop;
                }

            }

        }
        driver.quit();
    }
}
