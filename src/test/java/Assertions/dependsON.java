package Assertions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dependsON {
    @BeforeMethod
    public void beforesuite(){
        System.out.println("i am before suit");
       // System.out.println(0/0);
    }
    @Test
    public void login(){
        System.out.println("i have looged in succesfully");
//        fail the test case
//        System.out.println(0/0);
    }

    @Test(dependsOnMethods = "login")
    public  void verificationOfDashBoardPage(){

        System.out.println("i am on dashboard page");

    }
}
