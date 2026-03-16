package com.thetestingacademy.ex12_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Lab_Windows_P1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/windows");

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        WebElement link_parent = driver.findElement(By.xpath("//a[text()=\"Click Here\"]"));
        link_parent.click();

        //we need to create as Set and not List
        //as the list of names is unique
        Set<String> windows_handles_ids = driver.getWindowHandles();

        for(String window: windows_handles_ids){
            System.out.println(window);
            driver.switchTo().window(window);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Passed!");
            }
        }

        driver.switchTo().window(parent_id);

        driver.quit();
    }
}
