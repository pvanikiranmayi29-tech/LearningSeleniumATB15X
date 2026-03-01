package com.thetestingacademy;

import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium001 {
    public static void main(String[] args) {

        //Source Code - we will write here in this class
        //the source code is then converted to JSON Wire-protocol | HTTP request | API request
        //API Request will be sent to the Browser Driver |Server (application running on a particular port)
        //then browser driver will communicate to the real web driver
        //1.Source Code - 2.JSON Wire protocol - 3.Browser Driver - 4.Real Browser
        //this is till selenium 3

        //the problem with S3 - is we have to use different drivers for different browsers
        //ChromeDriver for Chrome, GeckoDriver for Firefox and so on.......

        //in Selenium 4 - we have 4 components
        //in S4 we will call W3C protocol instead of JSON Wire - like all will know english
        //w3c is nothing but a API request
        //we have something called Selenium manager
        //Selenium manager will automatically download the drivers and start the driver

        //in pom.xml - the dependencies the tags
        //groupid is nothing but a reverse domain
        //artifactid is the project name
        //<scope>test</scope> - that means the selenium related code we should write in test folder
        //it will not work in main folder
        //source code - using W3C protocol to connect with browser driver(eg:gecko for firefox) - geckodriver will start the server


        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");


    }
}
