package com.example.illcarro.qa.tests;
import com.example.illcarro.qa.application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBase {
    protected static ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp(){
        app.start();
    }

    @AfterSuite()
    public void tearDown(){
        app.stop();
    }
}
