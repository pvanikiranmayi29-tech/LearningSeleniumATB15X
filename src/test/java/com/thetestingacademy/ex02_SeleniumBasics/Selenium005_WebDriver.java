package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium005_WebDriver {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        driver.close();

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.close();
    }
}
