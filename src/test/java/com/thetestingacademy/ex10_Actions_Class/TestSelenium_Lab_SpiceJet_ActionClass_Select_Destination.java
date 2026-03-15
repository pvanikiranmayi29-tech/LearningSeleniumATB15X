package com.thetestingacademy.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium_Lab_SpiceJet_ActionClass_Select_Destination {

    @Test
    public void test_select_destination(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        WebElement travelFrom = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        WebElement travelTo = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div/div/input"));

        Actions actions = new Actions(driver);

        //here in spiceject we cannot directly find element and sendkeys
        //first we need to move to element
        //click the element
        //then sendkeys

        actions.moveToElement(travelFrom).click().sendKeys("blr")
                .moveToElement(travelTo).click().sendKeys("del")
                .build().perform();

    }
}
