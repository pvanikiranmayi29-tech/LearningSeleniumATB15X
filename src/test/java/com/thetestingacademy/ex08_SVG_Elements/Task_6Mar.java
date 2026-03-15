package com.thetestingacademy.ex08_SVG_Elements;

import com.thetestingacademy.CommonToAll;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Task_6Mar extends CommonToAll {

    WebDriver driver;

    @Description("Verify the search with svg icon results are visible")
    @Test
    public void test_Flipkart_Search_SVG_Icon(){

        driver = new ChromeDriver();
        openBrowser(driver, "https://www.flipkart.com/search");

        WebElement search_input = driver.findElement(By.name("q"));
        search_input.sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));
        svgElements.get(0).click();

        waitForVisibility(driver,"//div[contains(@data-id,'CPU')]");

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[2]"));

        List<WebElement> priceResult = driver.findElements(By.xpath("//div[contains(@data-id,'CPU') or contains(@data-id,'MPC')]/div/a[3]/div/div[1]"));

        double high_price=0;

        double low_price= Double.MAX_VALUE;

        for(int i=0;i<priceResult.size();i++){

            if(titleResults.get(i).getText().contains("Apple") && titleResults.get(i).getText().contains("Mini") || titleResults.get(i).getText().contains("Chip")) {

                System.out.println(titleResults.get(i).getText());
                System.out.println(priceResult.get(i).getText());

                String price_found = priceResult.get(i).getText();

                price_found = price_found.replaceAll("[^0-9.]", "");

                if (!price_found.isEmpty()) {
                    double priceFound = Double.parseDouble(price_found);

                    if (priceFound > high_price) {
                        high_price = priceFound;
                    }

                    if (priceFound < low_price) {
                        low_price = priceFound;
                    }
                }

            }
        }

        System.out.println("Highest price: " +high_price);

        System.out.println("Lowest price: " +low_price);

        closeBrowser(driver);
    }
}
