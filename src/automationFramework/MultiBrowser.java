/**
 * Created by prashant on 3/4/17.
 */
package automationFramework;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

public class MultiBrowser {

    public WebDriver driver;

    @Parameters("browser")

    @BeforeClass



    public void beforeTest(String browser) {



        if(browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();



        }else if (browser.equalsIgnoreCase("chrome")) {



            System.setProperty("webdriver.chrome.driver", "/home/prashant/prashant/chromedriver");

            driver = new ChromeDriver();

        }



        driver.get("http://www.edunuts.com/login");

    }



    @Test public void login() throws InterruptedException {

        WebElement city = driver.findElement(By.xpath("//a[@data-url='delhi']"));
        city.click();

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username / Email / Mobile']"));
        username.sendKeys("qwerty");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("qwerty");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

    }

    @AfterClass public void afterTest() {

        driver.quit();

    }

}