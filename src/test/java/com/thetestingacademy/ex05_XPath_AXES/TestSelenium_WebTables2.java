package com.thetestingacademy.ex05_XPath_AXES;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_WebTables2 {
    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Find elements in a dynamic table having header, body and footer")
    @Test
    public void test_web_table() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable1.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        //another way to find the rows in a table
        //List will get all the rows

        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rows = rows_table.size();

        for (int i = 0; i < rows; i++) {

            List<WebElement> cols_table = rows_table.get(i).findElements(By.tagName("td"));

            for (WebElement c : cols_table){
                System.out.println(c.getText());
            }
        }

        driver.quit();
    }
}
