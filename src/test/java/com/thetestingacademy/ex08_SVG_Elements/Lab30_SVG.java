package com.thetestingacademy.ex08_SVG_Elements;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Lab30_SVG extends CommonToAll {

    WebDriver driver;

    @Description("Verify the search with svg icon results are visible")
    @Test
    public void test_Flipkart_Search_SVG_Icon(){

        driver = new ChromeDriver();
        openBrowser(driver, "https://www.flipkart.com/search");

        WebElement search_input = driver.findElement(By.name("q"));
        search_input.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        //as the search icon is the first element
        svgElements.get(0).click();

        //waitforJVM(5000);

        //now to find and print all the titles
        //we have <a> tag but there is no unique way to find them
        //so we need to go one element above
        //and again another element above - and we have a data-id
        //but again data-id is having multiple id's but if we see it starts with CPU or MPC and so
        //so here we use xpath - //div[contains(@data-id,"CPU") or contains(@data-id,"MPC")]
        //this will not give title - under this div, another div and the second a
        //so finally xpath - //div[contains(@data-id,"CPU") or contains(@data-id,"MPC")]/div/a[2]

        //any of this is visible we are good to go
        //so we wait for atleast one to be loaded - which means elements are loaded
        waitForVisibility(driver,"//div[contains(@data-id,'CPU')]");

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[2]"));

        List<WebElement> priceResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[3]/div/div[1]"));


        for(WebElement title:titleResults){
            System.out.println(title.getText());

        }

        closeBrowser(driver);
    }
}
