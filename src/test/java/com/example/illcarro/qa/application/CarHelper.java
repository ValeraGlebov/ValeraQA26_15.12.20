package com.example.illcarro.qa.application;
import com.example.illcarro.qa.model.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }
    public void iniAddingNewCar(){
        click(By.cssSelector("header [href='/car']"));
    }

    public boolean isCarCreationFormPresent() {
        return isElementPresent(By.xpath("//h3[contains(., 'Let the car work')]"));
    }
    public void fillCarForm(Car car){
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
        type(By.cssSelector(".serial_number"), car.getSerial_number());
        type(By.cssSelector(".brand"), car.getBrand());
        type(By.cssSelector(".model"), car.getModel());
        type(By.cssSelector(".year"), car.getYear());
        type(By.cssSelector(".engine"), car.getEngine());
        type(By.cssSelector(".fuel_consumption"), car.getFuel_consumption());
        type(By.cssSelector(".fuel"), car.getFuel());
        type(By.cssSelector(".transmition"), car.getTransmition());
        type(By.cssSelector(".wd"), car.getwD());
        type(By.cssSelector(".horsepower"), car.getHorsepower());
        type(By.cssSelector(".torque"), car.getTorque());
        type(By.cssSelector(".doors"), car.getDoors());
        type(By.cssSelector(".seats"), car.getSeats());
        type(By.cssSelector(".class"), car.getClasS());
        type(By.cssSelector("[name='about']"), car.getAbout());
        type(By.cssSelector(".type_feature"), car.getFeature());
        type(By.cssSelector(".price"), car.getPrice());

    }

}
