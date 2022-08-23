package Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hardAssertions {
    public static WebDriver driver;
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/pim/viewEmployeeList");
        driver.manage().window().maximize();
    }
    @Test
    public void verifyCredentials() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("khalid123");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("123456");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        String errortext = driver.findElement(By.id("spanMessage")).getText();
        String expectedMessage = "Invalid credentials";
        Assert.assertEquals(errortext, expectedMessage);
        //re-assign username because DOM refreshed after clicking login
        //That's why we got the stale element exception error
        username = driver.findElement(By.id("txtUsername"));
        boolean displayed = username.isDisplayed();
        Assert.assertTrue(displayed);

    }
}
