package com.thetestingacademy.ex04_XPath;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium21_MiniProject_2 {

    @Owner("Vani")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Make Appointment")
    @Test
    public void test_katalon_make_appointment(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //in Xpath we have functions
        //where we can use text to find the external text - the display value on UI
        //xpath - //a[text()="Make Appointment"]
        //but this would fail if dev add a space - so to avoid space related problems
        //we can use //a[normalize-space()="Make Appointment"]
        //when it comes to button -we cannot give //button[text()="Sign in"] this will not work
        //here we need to find the span under the button //span[text()="Sign in"]

        //second function is partial text or contains
        //tagname[contains(@attribute,value)]
        //xpath will be //a[contains(text(),="Make")]

        //another function is starts with or ends with
        //eg. //img[starts-with(@alt,"Image")]
        //if in any case if we get more than one result and there is no other unique way to find element
        //to handle the list and to point to exact one
        //we can use list
        //List<WebElement> alt_images = driver.findElements(By.xpath("//img[starts-with(@alt,\"Image\")]"));
        //alt_images.get(0).click();

        //when with one condition - we are getting multiple elements
        //we can also use operators AND & OR
        //xpath - //a[text()="Make Appointment" and contains(@id,"btn-make-appointment")]



    }
}
