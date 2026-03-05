package com.thetestingacademy.ex05_XPath_AXES;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium_WebTables {

    @Owner("Vani")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Find a element in the table and print the related elements")
    @Test
    public void test_web_table(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/webtable.html");
        driver.manage().window().maximize();

        //Xpath to find Helen Bennett in the given table //table[@id="customers"]/tbody/tr[5]/td[2]
        //tr[i] => where i goes from 1 to 7 where 1 is the table headers and rest are table rows
        //td[j] => where j goes from 1 to 3 - no of columns in each row i

        //to give dynamic values to i and j - we need to divide the Xpath into 3 parts

        String first_part="//table[@id=\"customers\"]/tbody/tr[";
        //after the above square bracket - we will have i(dynamic value)
        String second_part="]/td[";
        //after the above square bracket - we will have j(dynamic value)
        String third_part="]";

        //when we have multiple items returning we need to use s for driver.findElements
        //.size will give us the count of rows
        int rows = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();

        int cols = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        for (int i = 2; i <= rows; i++) {
            for (int j = 1; j <=cols; j++) {
                String dynamic_xpath = first_part+i+second_part+j+third_part;
                System.out.println(dynamic_xpath);

                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data);

                //XPath Axes - we can use this to find the before and following elements
                //like in a tree structure
                //self - //div[@class="Mammal"]
                //Ancestors //div[@class="Mammal"]/ancestor::div
                //Followng - sibling //div[@class="Mammal"]/following-siblings::div
                //Preceding - sibling //div[@class="Mammal"]/preceding-siblings::div
                //Child - //div[@class="Mammal"]/child::div
                //Parent - //div[@class="Mammal"]/parent::div

                if(data.contains("Helen")){
                    //with this we can only find the xpath for country
                    String country_path = dynamic_xpath+"/following-sibling::td";
                    //to get the value that is present in the xpath
                    String country_value = driver.findElement(By.xpath(country_path)).getText();
                    String company = dynamic_xpath+"/preceding-sibling::td";
                    String company_value = driver.findElement(By.xpath(company)).getText();
                    System.out.println("---------------");
                    System.out.println("Helen Bennett is in - country - "+country_value+" company -"+company_value);

                }
            }
        }
    }
}
