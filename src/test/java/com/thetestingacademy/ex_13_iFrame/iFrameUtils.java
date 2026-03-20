package com.thetestingacademy.ex_13_iFrame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iFrameUtils {
    //generally in a framework we will create a iFrame utility
    //utility means we will not write the same code again and again

    WebDriver driver;

    public iFrameUtils(WebDriver driver){
        this.driver = driver;
    }

    //instead of always writing driver.switchTo and all
    //we created these common methods
    public void switchToDefault(){
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page/frame");
    }

    public void switchToParent(){
        driver.switchTo().parentFrame();
        System.out.println("Switched to Parent Frame");
    }

    //here we have added a wait
    //switch to frame once it is visible
    public void switchToFrame(String frameId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        System.out.println("Switched to Frame: " +frameId);
    }
}
