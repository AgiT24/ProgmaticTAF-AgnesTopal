package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private final By makeAppointmnetButtonBy = By.id("btn-make-appointment");

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickMakeAppointment() {
        WebElement makeAppointmentButton = driver.findElement(makeAppointmnetButtonBy);
        makeAppointmentButton.click();
    }
}
