package com.thetestingacademy.ex07_Selenium_Waits;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSeleniumExplicit_MiniProject4 extends CommonToAll {

    @Test
    public void testCloseModal(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());

        //in makemytrip the login modal window will appear afte 2-3 sec
        //so scenario is wait for the modal window and close

        //wait for this element //span[@data-cy='closeModal']

        //this is the explicit wait created
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //in explicit wait we will wait for the expectedcondition is met
        //here until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        //now instead of giving the above two lines always*/
        //we can extends this class with commontoAll and just use it like below

        waitForVisibility(driver,3,"//span[@data-cy='closeModal']");

        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));

        if(closeModal.isDisplayed()){
            closeModal.click();
            System.out.println("Close action performed");
            Assert.assertTrue(driver.findElements(By.xpath("//span[@data-cy='closeModal']")).isEmpty(), "Popup closed");
        }
        else {
            System.out.println("Close button not found");
        }

        //this is the code for thread.sleep with extends the InterruptedException class
        //this is not a selenium wait
        //but this code tells the JVM to hold the execution for given time
        //simply JVM wait
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
