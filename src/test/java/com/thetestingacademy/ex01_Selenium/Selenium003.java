package com.thetestingacademy.ex01_Selenium;

public class Selenium003 {
    public static void main(String[] args) {

        //Webdriver architecture
        //first comes the SearchContext which is an interface(which has incomplete functions)
        //Great Grand Father
        //then come WebDriver which is also an interface - GrandFather
        //then RemoteWebDriver which is class which implements WebDriver and few other extra capabilities
        //this is a Father
        //then comes the Child Drivers - ChromeDriver, FirefoxDriver, SafariDriver, EdgeDriver
        //these child drivers extends RemoteWebDriver

        //In S3 we need to setup the driver for each browser
        //System.getProperty("webdriver.gecko.driver","/path/geckdriver")

        //In s4, Selenium manager will take care of all - start and stop
        //EdgeDriver driver = new EdgeDriver();
        //driver.get("https://google.com");
    }
}
