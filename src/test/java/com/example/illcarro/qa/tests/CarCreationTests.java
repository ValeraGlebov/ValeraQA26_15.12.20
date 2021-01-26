package com.example.illcarro.qa.tests;
import com.example.illcarro.qa.model.Car;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CarCreationTests extends TestBase{
    @Test
    public void testCarCreation() throws InterruptedException{
        if(!app.getUser().isUserLoggedIn()){
            app.getUser().logIn(app.setEmail(), app.setPassword());
            //cmex3431608881578643@gmail.com --- Demo2015!
        }
        System.out.println("started testCarCreation");
        app.getCarHelper().iniAddingNewCar();
        Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());

        app.getCarHelper().fillCarForm(
                new Car()
                .setCountry("Israel")
                .setAddress("Herzell")
                .setDistance("500")
                .setSerial_number("45648453")
                .setBrand("Honda")
                .setModel("Civic")
                .setDoors("5")
                .setwD("4WD")
                .setSeats("4")
                .setYear("2015")
                .setEngine("H4567")
                .setTransmition("Auto")
                .setFuel("Solar")
                .setFuel_consumption("8")
                .setClasS("Van")
                .setHorsepower("150")
                .setTorque("240")
                .setAbout("Nosmoking")
                .setFeature("FDeature")
                .setPrice("500"));
        app.getCarHelper().pause(2000);
        app.getCarHelper().clickYallaButton();

    }
}
