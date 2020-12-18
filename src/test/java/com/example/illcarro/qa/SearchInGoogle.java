package com.example.illcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchInGoogle {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
    }


    @Test
    public void searchTest() throws InterruptedException{
        wd.get("https:/google.com");
        WebElement element = wd.findElement(By.name("q"));
        element.click();
        element.sendKeys("Gradle");
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
       wd.quit();
    }
}
