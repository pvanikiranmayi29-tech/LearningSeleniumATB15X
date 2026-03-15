package com.thetestingacademy.ex10_Actions_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium_ActionsClass {

    @Test
    public void test_actions(){
        WebDriver driver = new ChromeDriver();
        String url = "https://awesomeqa.com/practice.html";
        driver.get(url);

        WebElement firstName = driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        //we want to enter char with shift so that they will enter capital letters
        actions.keyDown(Keys.SHIFT).sendKeys(firstName, "the testing academy")
                .keyUp(Keys.SHIFT).build().perform();

        //the above actions does the same like below
        //firstName.sendKeys("THE TESTING ACADEMY");


    }
}
