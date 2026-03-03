package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium08_Maximize_Minimize {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

        driver.manage().window().maximize();
        System.out.println("Windown Maximized");

        driver.manage().window().minimize();
        System.out.println("Windown Minimized");

        driver.close();
    }
}
