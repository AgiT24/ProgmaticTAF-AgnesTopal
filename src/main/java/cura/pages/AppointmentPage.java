package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        Select facilityDropdown = new Select(driver.findElement(facilityDropdownBy));
        facilityDropdown.selectByVisibleText(facility);
    }

    public void applyForHospitalReadmission(Boolean apply) {
        if(apply) {
            WebElement applyForHospReadm = driver.findElement(hospitalReadmissionCheckboxBy);
            applyForHospReadm.click();
        }
    }

    public void selectHealthCareRadio (String healthcare) {
       WebElement healthCareRadioBtn = driver.findElement(By.id("radio_program_"+healthcare.toLowerCase()));
       healthCareRadioBtn.click();
    }
    public void fillDateInput (String date) {
        WebElement dateInput = driver.findElement(dateInputBy);
        dateInput.sendKeys(date);
    }

    public void fillCommentInput (String comment) {
        WebElement commentInput = driver.findElement(commentInputBy);
        commentInput.sendKeys(comment);
    }

    public void clickBookAppointmentBtn () {
        WebElement bookAppoinmentBtn = driver.findElement(bookAppointmentBtnBy);
        bookAppoinmentBtn.click();
    }


}
