package com.example.illcarro.qa.tests;

import com.example.illcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest extends TestBase {

    @BeforeMethod
    public void ensurePreConditions(){
     /*if user logged in, logOut  */
        if(app.getUser().isUserLoggedIn()){
            app.getUser().clickLogoutBtnOnHeader();
        }
    }
    @Test
    public void testLogin() throws InterruptedException {
        logger.info("\n User name is: cmex3431608881578643@gmail.com \n User Password is: Demo2015!");
        app.getUser().clickLogInBtn();
        //app.getUser().fillLoginForm("cmex3431608881578643@gmail.com", "Demo2015!");
        app.getUser().fillLoginForm(new User()
                .withEmail("cmex3431608881578643@gmail.com")
                .withPassword("Demo2015!"));
        app.getUser().pause(1000);
        app.getUser().clickYallaButton();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isUserLoggedIn());
    logger.info("Test Passed");
    String screenshot = "/src/test/screenshots/screenshot- " + System.currentTimeMillis() + ".png";

    app.getUser().takeScreenshot(screenshot);
    logger.info("Screenshot created: " + screenshot);
    }
}
