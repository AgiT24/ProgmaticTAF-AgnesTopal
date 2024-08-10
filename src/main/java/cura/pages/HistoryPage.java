package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HistoryPage {

    private final By menuButtonBy = By.id("menu-toggle");
    private final By historyButtonBy = By.linkText("History");
    private final By facilityBy = By.id("facility");
    private final By hospReadmBy = By.id("hospital_readmission");
    private final By healthCareBy = By.id("program");
    private final By commentBy = By.id("comment");

    private WebDriver driver;

    public HistoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHistory() {
        System.out.println("Opening Menu");
        driver.findElement(menuButtonBy).click();
        System.out.println("Clicking on History");
        driver.findElement(historyButtonBy).click();
    }

    public boolean checkAppointmentData(String facility, Boolean hospReadmApply, String program, String comment) {
        System.out.println("Checking if history data is the same as application data");
        System.out.println("Checking facility");
        boolean facilityCorrect = driver.findElement(facilityBy).getText().equals(facility);
        System.out.println("Checking Hospital Readmission");
        boolean hospReadmCorrect = false;
        if (hospReadmApply)
            if (driver.findElement(hospReadmBy).getText().equals("Yes"))
                hospReadmCorrect = true;
            else if (driver.findElement(hospReadmBy).getText().equals("No"))
                hospReadmCorrect = true;
        System.out.println("Checking Health Care program");
        boolean healthCareprogramCorrect = driver.findElement(healthCareBy).getText().equals(program);
        System.out.println("Checking comment");
        boolean commentCorrect = driver.findElement(commentBy).getText().equals(comment);
        return facilityCorrect && hospReadmCorrect && healthCareprogramCorrect && commentCorrect;
    }

}
