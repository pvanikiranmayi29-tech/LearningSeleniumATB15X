package com.thetestingacademy.ex_13_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFrame2 {

    @Test
    public void test_frame(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        //instead of using this
        //driver.switchTo().frame("result");

        //new iFrameUtils(driver).switchToFrame("result");
        //or we can create complete object

        iFrameUtils frameUtils= new iFrameUtils(driver);

        frameUtils.switchToFrame("result");
        driver.findElement(By.id("username")).sendKeys("Vani");
        frameUtils.switchToDefault();

    }
}
