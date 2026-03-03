package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSelenium14_Close_vs_Quit {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(10000);

        //driver.close();
        //close will only close the current window which the code is working on
        //if we manually open any other windows they remain as-is

        //quit will close the session and not jsut the window
        driver.quit();
    }
}
