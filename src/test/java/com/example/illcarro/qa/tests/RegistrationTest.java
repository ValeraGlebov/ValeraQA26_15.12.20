package com.example.illcarro.qa.tests;
import com.example.illcarro.qa.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

   @Test
   public void testRegistration() throws InterruptedException{

       app.getUser().openRegForm();
       String email = "cmex343" + System.currentTimeMillis() + "@gmail.com";
       app.getUser().FillRegForm(new User()
       .withName("Valerii")
       .withSurname("Glebov")
       .withEmail(email)
       .withPassword("Demo2015!"));
       app.getUser().clickCheckBox();
       app.getUser().pause(2000);
       app.getUser().clickYallaButton();
       app.getUser().pause(3000);
       Assert.assertFalse(app.getUser().isUserLoggedIn());
   }
    public void testRegistrationNegative() throws InterruptedException{
        app.getUser().openRegForm();
        String email = "cmex343" + System.currentTimeMillis() + "@gmail.com";
        app.getUser().FillRegForm(new User()
                        .withName("Valerii")
                        .withSurname("Glebov")
                        .withPassword("Demo2015!"));
        app.getUser().clickCheckBox();
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isRegistrationFormPresent());
        Assert.assertFalse(app.getUser().isUserLoggedIn());
    }
    public void testRegistrationNegative2() throws InterruptedException{
        app.getUser().openRegForm();
        String email = "cmex343" + System.currentTimeMillis() + "@gmail.com";
        app.getUser().FillRegForm(new User()
                .withName("Valerii")
                .withSurname("Glebov")
                .withEmail(email));
        app.getUser().clickCheckBox();
        app.getUser().pause(2000);
        app.getUser().clickYallaButton();
        app.getUser().pause(2000);
        Assert.assertTrue(app.getUser().isRegistrationFormPresent());
        Assert.assertFalse(app.getUser().isUserLoggedIn());
    }
}

