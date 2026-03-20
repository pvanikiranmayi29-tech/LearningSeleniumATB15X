package com.thetestingacademy.ex_13_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFrame {

    @Test
    public void test_frame(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        //even though the element has the id we cannot use this function
        //as the element is inside a iFrame

        //driver.findElement(By.id("username")).sendKeys("Vani");

        //if in any case - if we get error NoSuchElementException
        //it could be bcoz that element is inside a iFrame
        //if we cannot find it directly - we can do a find and give iFrame and we can find if we have any
        //iFrames in the page

        //to work on any element which is within a iFrame
        //we need to first switch to iFrame
        //iFrame can be reached only with name or id
        //if these are not there then index is the only way
        driver.switchTo().frame("result");
        //after switching to the iFrame - we can perform the above action - which was failing earlier will pass now
        driver.findElement(By.id("username")).sendKeys("Vani");

    }
}
