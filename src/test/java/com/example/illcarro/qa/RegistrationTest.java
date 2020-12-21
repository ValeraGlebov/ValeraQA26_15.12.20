package com.example.illcarro.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver wd;

   @BeforeMethod
   public void setUp(){
       wd = new ChromeDriver();
       wd.get("https://ilcarro-dev-v1.firebaseapp.com/");

   }
   @Test
   public void testRegistration() throws InterruptedException{
        //open reg Form
       wd.findElement(By.cssSelector("[href='/signup']")).click();
       wd.findElement(By.id("first_name")).click();
       wd.findElement(By.id("first_name")).clear();
       wd.findElement(By.id("first_name")).sendKeys("Valera");

       wd.findElement(By.id("second_name")).click();
       wd.findElement(By.id("second_name")).clear();
       wd.findElement(By.id("second_name")).sendKeys("Glebov");

       wd.findElement(By.id("email")).click();
       wd.findElement(By.id("email")).clear();
       wd.findElement(By.id("email")).sendKeys("cmex342@gmail.com");

       wd.findElement(By.id("password")).click();
       wd.findElement(By.id("password")).clear();
       wd.findElement(By.id("password")).sendKeys("Demo2014!");

       wd.findElement(By.id("check_policy")).click();
       Thread.sleep(2000);
       wd.findElement(By.className("yalla_yalla__1Jxk6")).click();


       //wd.findElement(By.cssSelector("[href='/car']")).click();
      //wd.findElement(By.name("address")).click();
       //fillRegForm

       //selectCheckBox
       //ClickYallaButton
   }
   @AfterMethod
    public void tearDown(){

   }
}

