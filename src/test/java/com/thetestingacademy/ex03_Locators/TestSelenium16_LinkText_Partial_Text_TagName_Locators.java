package com.thetestingacademy.ex03_Locators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium16_LinkText_Partial_Text_TagName_Locators {

    //this @Description annotation is coming from allure
    @Description("Verify that the create account Negative TC")
    @Test
    public void test_vwo()
    {
        //when working with anchor tags - we will not have id or name
        //and when a tag has a name which is displayed on the screen
        //this can be used to find the element
        //we can find the a tag element in two ways
        //LinkText - Full Text Match
        //Partial LinkText - Partial Match

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        /*WebElement a_Tag_free_trail_full_match = driver.findElement(By.linkText("Start a free trial"));
        a_Tag_free_trail_full_match.click();*/

        //full match can sometimes fail when the element name is changed by dev or business later in the development
        //so partial match is ideal and we find a parital text which is unique and will work on that


        WebElement a_partial_match = driver.findElement(By.partialLinkText("trial"));
        a_partial_match.click();

        driver.quit();
    }
}
