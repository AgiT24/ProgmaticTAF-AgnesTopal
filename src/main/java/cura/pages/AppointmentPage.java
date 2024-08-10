package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AppointmentPage {
    private final By facilityDropdownBy = By.id("combo_facility");
    private final By hospitalReadmissionCheckboxBy = By.id("chk_hospotal_readmission");
    private final By dateInputBy = By.id("txt_visit_date");
    private final By commentInputBy = By.id("txt_comment");
    private final By bookAppointmentBtnBy = By.id("btn-book-appointment");
    private WebDriver driver;

    public AppointmentPage(WebDriver driver) {
        this.driver = driver;
    }


    public void selectFacility(String facility) {
        System.out.println("Selecting facility: " + facility);
        Select facilityDropdown = new Select(driver.findElement(facilityDropdownBy));
        facilityDropdown.selectByVisibleText(facility);
    }

    public void applyForHospitalReadmission(Boolean apply) {
        System.out.println("Filling Hospital Readmission application with: " + apply);
        if (apply) {
            WebElement applyForHospReadm = driver.findElement(hospitalReadmissionCheckboxBy);
            applyForHospReadm.click();
        }
    }

    public void selectHealthCareRadio(String healthcare) {
        System.out.println("Selecting Health Care: " + healthcare);
        WebElement healthCareRadioBtn = driver.findElement(By.id("radio_program_" + healthcare.toLowerCase()));
        healthCareRadioBtn.click();
    }

    public void fillDateInput(String date) {
        System.out.println("Filling in visit date with: " + date);
        WebElement dateInput = driver.findElement(dateInputBy);
        dateInput.sendKeys(date);
    }

    public void fillCommentInput(String comment) {
        System.out.println("Writing comment: " + comment);
        WebElement commentInput = driver.findElement(commentInputBy);
        commentInput.sendKeys(comment);
    }

    public void clickBookAppointmentBtn() {
        System.out.println("Clicking on Book Appointment button to submit");
        WebElement bookAppointmentBtn = driver.findElement(bookAppointmentBtnBy);
        bookAppointmentBtn.click();
    }


}
