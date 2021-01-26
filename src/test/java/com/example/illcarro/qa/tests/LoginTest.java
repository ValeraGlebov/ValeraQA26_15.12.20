package com.example.illcarro.qa.tests;
import com.example.illcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"cmex1@gmail.com","Demo2015!"});
        list.add(new Object[]{"cmex2@gmail.com","Demo2015!"});
        list.add(new Object[]{"cmex3@gmail.com","Demo2015!"});
        return list.iterator();
    }
    @DataProvider
    public  Iterator<Object[]> validLoginFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader(new File("src/test/resources/ValidLoginTypeCSV.csv")));

        String line = reader.readLine();
        while(line != null){
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider = "validLoginFromCSV")
    public void testLoginDataProviderCSV(User user) throws InterruptedException {
        logger.info("\n User name is: " + user.getEmail() + "\n User Password is: " + user.getPassword());
        app.getUser().clickLogInBtn();
        app.getUser().fillLoginForm(user);
        app.getUser().pause(1000);
        app.getUser().clickYallaButton();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isUserLoggedIn());
        logger.info("Test Passed");
        String screenshot = "src/test/screenshots/screenshot" + System.currentTimeMillis() + ".png";
        app.getUser().takeScreenshot(screenshot);
        logger.info("Screenshot created: " + screenshot);
    }
    @Test(dataProvider = "validLogin")
    public void testLoginDataProvider(String email,String password) throws InterruptedException {
        logger.info("\nUser name is: " + email +  "\nUser Password is: " + password);
        app.getUser().clickLogInBtn();
        //app.getUser().fillLoginForm("cmex3431608881578643@gmail.com", "Demo2015!");
        app.getUser().fillLoginForm(new User()
                .withEmail(email)
                .withPassword(password));
        app.getUser().pause(1000);
        app.getUser().clickYallaButton();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isUserLoggedIn());
        logger.info("Test Passed");
        String screenshot = "src/test/screenshots/screenshot-" + System.currentTimeMillis() + ".png";

        app.getUser().takeScreenshot(screenshot);
        logger.info("Screenshot created: " + screenshot);
    }
    @Test
    public void testLoginSanity() throws InterruptedException {
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
        String screenshot = "src/test/screenshots/screenshot-" + System.currentTimeMillis() + ".png";

        app.getUser().takeScreenshot(screenshot);
        logger.info("Screenshot created: " + screenshot);
    }

    @BeforeMethod
    public void ensurePreConditions(){
        if(app.getUser().isUserLoggedIn()){
            app.getUser().clickLogoutBtnOnHeader();
        }
    }
}
