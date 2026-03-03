package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium07_Selenium_Commands {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");

        System.out.println(driver.getTitle());
        System.out.println("-------------------------");
        System.out.println(driver.getCurrentUrl());
        System.out.println("-------------------------");
        System.out.println(driver.getPageSource());
        System.out.println("--------------------------");

        driver.quit();
    }
}
