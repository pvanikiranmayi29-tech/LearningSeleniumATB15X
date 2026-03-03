package com.thetestingacademy.ex02_SeleniumBasics;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium13_NOHTTP {
    public static void main(String[] args) {

        FirefoxDriver driver = new FirefoxDriver();
        driver.get("bing.com");
        //without giving http - this will fail
        //Http is imp

    }
}
