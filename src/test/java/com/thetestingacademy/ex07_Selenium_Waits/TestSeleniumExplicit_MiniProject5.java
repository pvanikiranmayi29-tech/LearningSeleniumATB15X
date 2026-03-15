package com.thetestingacademy.ex07_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeleniumExplicit_MiniProject5 extends CommonToAll {

    @Test
    public void testCloseModal(){

        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://www.makemytrip.com/");
        waitForVisibility(driver,3,"//span[@data-cy='closeModal']");
        find_and_clickElement("//span[@data-cy='closeModal']");
        waitforJVM(3000);
        closeBrowser(driver);
    }
}
