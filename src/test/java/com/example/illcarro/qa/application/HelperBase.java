package com.example.illcarro.qa.application;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class HelperBase {
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    WebDriver wd;
    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xPathSelector) {
        wd.findElement(By.xpath(xPathSelector)).click();
    }
    public void click(By locator) {
        //wd.findElement(locator).click();
        Actions action = new Actions(wd);
        action.moveToElement(wd.findElement(locator)).click().perform();
    }
    public void typeByElement(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void pause(int millis) throws InterruptedException{
        Thread.sleep(millis);
    }
    public void clickYallaButton() {
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }
    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File (pathToFile);
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
