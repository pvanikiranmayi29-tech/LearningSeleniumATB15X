package com.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CommonToAll {

    //This class can be used as a class for all common functions
    //which we do multiple times in different programs
    //like open browser, close browser, wait and so on

    public ChromeDriver driver;

    public void openBrowser(WebDriver driver, String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }

    public void waitForVisibility(WebDriver driver,int timeInSeconds,String given_xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(given_xpath)));
    }

    //in same common to all class - we can create multiple methods with same name but diff args
    //method overloading

    //this method is to wait for 5seconds and above method sec is also dynamic
    public void waitForVisibility(WebDriver driver,String given_xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(given_xpath)));
    }


    public void waitForTextToBePresent(WebDriver driver,int timeInSeconds,String given_xpath, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath(given_xpath)),text));
    }

    public void waitForAlert(WebDriver driver,int timeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitforJVM(int time){
        try{
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public void find_and_clickElement(String given_xpath){
        WebElement element = driver.findElement(By.xpath(given_xpath));
        if(element.isDisplayed()){
            element.click();
            System.out.println("Close action performed");
            Assert.assertTrue(driver.findElements(By.xpath(given_xpath)).isEmpty(), "Popup closed");
        }
        else {
            System.out.println("Close button not found");
        }
    }

    public void waitForClickable(WebDriver driver,String given_css){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(given_css)));
        Button.click();
    }
}
