package com.thetestingacademy.ex12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Lab_Windows_P2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        WebElement link_parent = driver.findElement(By.xpath("//a[normalize-space()=\"Start a FREE TRIAL\"]"));
        link_parent.click();

        //we need to create as Set and not List
        //as the list of names is unique
        Set<String> windows_handles_ids = driver.getWindowHandles();

        for(String window: windows_handles_ids){
            System.out.println(window);
            //this if code switches to window - which is not the parent window
            if(!window.equalsIgnoreCase(parent_id)){
                driver.switchTo().window(window);

                //here we can verify whatever we need to verify in child window
            }

        }
        //then if needed we can switch back to parent
        //driver.switchTo().window(parent_id);

        driver.quit();
    }
}
