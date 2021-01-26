package com.example.illcarro.qa.application;

import com.example.illcarro.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logIn(String email, String password) throws InterruptedException {
        clickByCss("[href='/login']");
        fillLoginForm(new User()
                .withEmail(email) //"cmex3431608881578643@gmail.com"
                .withPassword(password));
        pause(2000);
        clickByCss("[type=submit]");
        pause(2000);
    }
    public boolean isRegistrationFormPresent(){
        return isElementPresent(By.xpath("//h2[contains(., 'Registration')]"));
    }
    public void AssertFalseSignIn() {
        Assert.assertFalse(wd.findElements(By.xpath("//h2[contains(., 'Registration')]")).size() > 0);
    }

    public void clickCheckBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void FillRegForm(User user) {
        type(By.id("first_name"), user.getName());
        type(By.cssSelector("#second_name"), user.getSurname());
        type(By.cssSelector("#email"), user.getEmail());
        System.out.println("Email is:" + user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void fillLoginForm(User user) {
        typeByCss("[name=email]",user.getEmail());
        typeByCss("[name=password]", user.getPassword());
    }

    public void clickLogoutBtnOnHeader() {
        click(By.xpath("//a[contains(., 'logOut')]"));
    }

    public void clickLogInBtn() {
        clickByCss("[href='/login']");
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(., 'logOut')]"));
    }
}
