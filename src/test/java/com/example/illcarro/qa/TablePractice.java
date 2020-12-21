package com.example.illcarro.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TablePractice {
    WebDriver wd;
    @BeforeClass
    public void setUp(){
    wd = new ChromeDriver();
    }
    @Test
    public void tablePractice(){

    }
    @AfterClass
    public void tearDown(){
        //wd.close();
        wd.quit();
    }
}
