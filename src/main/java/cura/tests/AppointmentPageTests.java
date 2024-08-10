package cura.tests;

import core.DriverManager;
import cura.pages.AppointmentPage;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "Fills in appointment booiking form and checks if the booking was confirmed")
    public void bookAppointment() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.applyForHospitalReadmission(true);
        appointmentPage.selectHealthCareRadio("None");
        appointmentPage.fillDateInput("2024/08/09");
        appointmentPage.fillCommentInput("I have a fewer");
        appointmentPage.clickBookAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }


}
