package cura.tests;

import core.DriverManager;
import cura.pages.AppointmentPage;
import cura.pages.HomePage;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "check if Make Appointment button works")
    public void isMakeAppointmentClickable() {
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        login();
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.applyForHospitalReadmission(true);
        appointmentPage.selectHealthCareRadio("None");
        appointmentPage.fillDateInput("2024/08/09");
        appointmentPage.fillCommentInput("I have a fewer");
        appointmentPage.clickBookAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }

    public void login(){

        HomePage homePage=new HomePage(driver);
        homePage.clickMakeAppointment();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("John Doe");
        loginPage.fillPasswordInput("ThisIsNotAPassword");
        loginPage.clickLogin();
    }
}
