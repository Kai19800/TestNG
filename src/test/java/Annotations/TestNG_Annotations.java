package Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Annotations {
    @Test
    public void firstTestCase() {
        System.out.println("Hello, this is my first test case");
    }

    @Test
    public void secondTestCase() {
        System.out.println("Hello, this is my second test case");
    }

    @Test
    public void thirdTestcase() {
        System.out.println("hello, this is my third test case");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Heyy! I AM THE BEFORE METHOD");
    }

    @AfterMethod
    public void afterMEthod() {
        System.out.println("Heyy! I AM THE AFTER METHOD");
    }
}
