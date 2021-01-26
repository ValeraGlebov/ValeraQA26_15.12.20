package com.example.illcarro.qa.tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(!app.getUser().isUserLoggedIn()){
            app.getUser().logIn(app.setEmail(), app.setPassword());
            //cmex3431608881578643@gmail.com --- Demo2015!
        }
    }
    @Test
    public void logoutTest() throws InterruptedException {
    app.getUser().logIn("cmex3431608881578643@gmail.com", "Demo2015!");
    app.getUser().clickLogoutBtnOnHeader();
        Assert.assertFalse(app.getUser().isUserLoggedIn());
    }
}
