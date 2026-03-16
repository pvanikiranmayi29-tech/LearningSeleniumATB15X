package com.thetestingacademy.ex12_Windows;

import com.thetestingacademy.CommonToAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class TestSelenium_Task11Mar_Singup extends CommonToAll {


    @Test
    public void test_singup() throws IOException, UnsupportedFlavorException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--incognito");

        // Disable automation flags
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Start browser maximized (looks more human)
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com/#/login");

        String parent_id = driver.getWindowHandle();
        System.out.println(parent_id);

        WebElement link_parent = driver.findElement(By.xpath("//a[normalize-space()=\"Start a FREE TRIAL\"]"));
        link_parent.click();

        Set<String> windows_handles_ids = driver.getWindowHandles();

        for(String window: windows_handles_ids){
            System.out.println(window);
            if(!window.equalsIgnoreCase(parent_id)){
                driver.switchTo().window(window);

                WebElement signup_email = driver.findElement(By.xpath("//input[@data-qa=\"page-su-step1-v1-email\"]"));
                signup_email.sendKeys("pvanikiranmayi29@gmail.com");

                //waitforJVM(2000);
                WebElement signup_error = driver.findElement(By.xpath("//form[@id=\"page-free-trial-signup-form-step1\"]/div/div"));
                waitForVisibility(driver,"//form[@id=\"page-free-trial-signup-form-step1\"]/div/div");

                //System.out.println(signup_error.isDisplayed());
                //System.out.println(signup_error.getText());
                if(signup_error.getText().equalsIgnoreCase("gmail.com doesn't look like a business domain. Please use your business email.")){
                    System.out.println("gmail error displayed");
                }
                else {
                    System.out.println("gmail error not displayed");
                }

                signup_email.clear();
                waitforJVM(2000);
                signup_email.sendKeys("vanishravanani@gymzz.com");

                WebElement i_agree = driver.findElement(By.xpath("//input[@data-qa=\"page-free-trial-step1-gdpr-consent-checkbox\"]"));
                i_agree.click();

                WebElement submit_signup = driver.findElement(By.xpath("//button[@data-qa=\"page-su-submit\"]"));
                System.out.println(submit_signup.getText());
                submit_signup.click();

                waitForVisibility(driver,3000,"//input[@data-qa='page-su-step2-v1-email']");

                WebElement firstname = driver.findElement(By.xpath("//input[@data-qa=\"page-su-v1-fname\"]"));
                firstname.sendKeys("udeud");

                waitforJVM(500);

                WebElement lname = driver.findElement(By.xpath("//input[@data-qa=\"page-su-v1-lname\"]"));
                lname.sendKeys("vrwfwne");

                waitforJVM(500);

                WebElement phone = driver.findElement(By.xpath("//input[@data-qa=\"page-su-v1-pnumber\"]"));

                waitforJVM(3000);

                WebElement submit = driver.findElement(By.xpath("//button[@data-qa='page-su-submit']"));
                System.out.println(submit.isEnabled());

                Actions actions = new Actions(driver);

                actions.moveToElement(phone).click()
                        .sendKeys("9180954565")
                        .pause(4000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.ENTER)
                        .pause(2000)
                        .keyUp(Keys.ENTER)
                        .pause(2000)
                        .build().perform();



                waitForVisibility(driver,"//div/h3[contains(text(),\"1-on-1\")]");

                waitForClickable(driver,"button[data-step='free-trial-thankyou']");

                waitForVisibility(driver,2000,"//div/h4[contains(text(),\"Basic\")]");

                WebElement choose = driver.findElement(By.xpath("//h5[contains(text(),\"Choose\")]"));
                choose.click();

                actions.moveToElement(choose).click()
                        .pause(4000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.ENTER)
                        .pause(2000)
                        .keyUp(Keys.ENTER)
                        .pause(2000)
                        .build().perform();

                waitforJVM(1000);

                waitforJVM(1000);

                //moveToElement(h5).click()
                actions.pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.ENTER)
                        .pause(2000)
                        .keyUp(Keys.ENTER)
                        .pause(2000)
                        .build().perform();

                waitforJVM(5000);

                waitforJVM(5000);

                //moveToElement(h6).click()
                actions.pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.TAB)
                        .pause(2000)
                        .keyUp(Keys.TAB)
                        .pause(2000)
                        .keyDown(Keys.ENTER)
                        .pause(2000)
                        .keyUp(Keys.ENTER)
                        .pause(2000)
                        .build().perform();


                waitforJVM(4000);

                actions.pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.TAB)
                        .pause(1000)
                        .keyUp(Keys.TAB)
                        .pause(1000)
                        .keyDown(Keys.ENTER)
                        .pause(1000)
                        .keyUp(Keys.ENTER)
                        .pause(1000)
                        .build().perform();

                waitforJVM(2000);

                Toolkit toolkit = Toolkit.getDefaultToolkit();
                String copied_text = (String) toolkit.getSystemClipboard().getData(DataFlavor.stringFlavor);

                System.out.println(copied_text);

                if(copied_text.contains("https://dev.visualwebsiteoptimizer.com/j.php?'+i();-1!==w.location.search.indexOf('_vwo_xhr')"))
                {
                    System.out.println("Given Phrase found");
                }
                else {
                    System.out.println("Text not found");
                }
            }
        }

        driver.quit();
    }
}
