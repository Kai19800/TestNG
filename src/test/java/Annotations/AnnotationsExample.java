package Annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsExample {
public static WebDriver driver;
    @Test
    public void testHRM() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("kdc.hhh@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("ffsgd124");
        String text = driver.findElement(By.xpath("//h2")).getText();
        if (text.equals("Connect with friends and the world around you on Facebook.")) {
            System.out.println("Successful");
        } else {
            System.out.println("Failed");
        }
    }
    @Test
    public void createAccountTest() {
        String createAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).getText();
        if (createAccountButton.equals("Create new account")) {
            System.out.println("Text is visible");
        } else {
            System.out.println("Failed");
        }
    }
    @BeforeMethod
    public void settingUpBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://fb.com");
    }
    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}