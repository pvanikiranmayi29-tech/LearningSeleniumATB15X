import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class TestSelenium4_WebDriver_Hierarchy {
    public static void main(String[] args) {

        //SearchContext context = new SearchContext(); //this is not allowed as we cannot create obj for interface
        /*SearchContext context = new ChromeDriver();
        WebDriver driver = new ChromeDriver();
        RemoteWebDriver driver1 = new ChromeDriver();
        ChromeDriver driver2 = new ChromeDriver();*/
        //all these are correct syntax

        //why do we need to do like this

        //Scenarios
        //1. Do want to run on only one browser Chrome or Edge
        //then we can use
        ChromeDriver driver = new ChromeDriver();
        //driver = FirefoxDriver();//we cannot later chnage the driver

        //2. Do want to run on Chrome then chnage to Edge or something
        WebDriver driver1 = new ChromeDriver();
        driver1 = new FirefoxDriver();
        driver1 = new EdgeDriver();

        //3. Do we want to run on multiple drivers only or
        //we have some other AWS machine and want to run there
        //in this case we use
        //RemoteWebDriver driver2(with GRID) - Adv topic - we will discuss later
    }
}
