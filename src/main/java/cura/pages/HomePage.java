package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final By makeAppointmnetButtonBy = By.id("btn-make-appointment");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMakeAppointment() {
        WebElement makeAppointmentButton = driver.findElement(makeAppointmnetButtonBy);
        System.out.println("Clicking on Make Appointment button");
        makeAppointmentButton.click();
    }
}
