package Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertions {
    public static WebDriver driver;
    @BeforeMethod (alwaysRun = true)
    public void openChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/pim/viewEmployeeList");
        driver.manage().window().maximize();
    }
    @Test(groups = "regression")
    public void invalidCredentials() {
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("khalid123");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("123456");
        WebElement login = driver.findElement(By.id("btnLogin"));
        login.click();
        //Verify error message for invalid credentials
        WebElement errortext = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String ErrorTextMsg= errortext.getText();;

        // Why don't I just do this:
        // String errortext = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
        //
        String expectedText="Invalid credentials";
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(ErrorTextMsg, expectedText);

        //Let's see if username box is displayed
        userName = driver.findElement(By.id("txtUsername"));
        boolean displayed= userName.isDisplayed();;
        soft.assertTrue(displayed);

        soft.assertAll();
    }
@AfterMethod(alwaysRun = true)
    public void closeBroswer(){
        driver.quit();
}
}