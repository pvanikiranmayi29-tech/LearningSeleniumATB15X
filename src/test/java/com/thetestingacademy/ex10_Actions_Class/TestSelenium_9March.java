package com.thetestingacademy.ex10_Actions_Class;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium_9March extends CommonToAll {

    @Test
    public void test_booking_com(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.booking.com");

        waitforJVM(2000);

        Allure.step("Close pop-up");
        WebElement close_pop = driver.findElement(By.xpath("//button[@aria-label=\"Dismiss sign-in info.\"]"));

        close_pop.click();

        Allure.step("Find Flight tab and select");
        WebElement find_flight = driver.findElement(By.xpath("//a[@id=\"flights\"]"));
        find_flight.click();

        //waitforJVM(5000);
        waitForVisibility(driver,5000,"//h1[contains(text(),\"Compare and book\")]");

        Allure.step("Enter destination as DEL");
        WebElement goingTo = driver.findElement(By.xpath("//button[@data-ui-name=\"input_location_to_segment_0\"]"));

        goingTo.click();

        //waitforJVM(2000);

        WebElement typeTo = driver.findElement(By.xpath("//input[@data-ui-name=\"input_text_autocomplete\"]"));

        waitForVisibility(driver,"//div[@class=\"AutoComplete-module__wrapper___d3PlU\"]/div[contains(text(),\"Airport\")]");

        Actions actions = new Actions(driver);

        actions.moveToElement(typeTo).click()
                .sendKeys("Delhi")
                .pause(4000)
                .keyDown(Keys.TAB)
                .pause(2000)
                .keyUp(Keys.TAB)
                .pause(2000)
                .keyDown(Keys.ENTER)
                .pause(4000)
                .keyUp(Keys.ENTER)
                .pause(1000)
                .build().perform();

        //WebElement summary = driver.findElement(By.xpath("//h2[contains(text(),\"Search\")]"));

        WebElement seacrh = driver.findElement(By.xpath("//button[@data-ui-name=\"button_search_submit\"]"));

        seacrh.click();

        Allure.step("Search results displayed");
        //waitForVisibility(driver,"//h2[contains(text(),\"Search\")]");
        waitforJVM(5000);

        WebElement to_airport = driver.findElement(By.xpath("//button[@data-ui-name=\"input_location_to_segment_0\"]/div/span[2]/span/span/span[2]/b"));

        //System.out.println(to_airport.getText());
        Assert.assertEquals(to_airport.getText(),"DEL");
        if(to_airport.getText().equals("DEL"))
        {
            System.out.println("To Airport is selected as DEL");
        }
        else {
            System.out.println("To Airport is not selected as DEL");
        }

        driver.quit();
    }
}
