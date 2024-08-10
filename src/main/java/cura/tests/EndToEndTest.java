package cura.tests;

import core.DriverManager;
import cura.pages.AppointmentPage;
import cura.pages.HistoryPage;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverManager {

    String facility = "Hongkong CURA Healthcare Center";
    Boolean applyForHospReadm = true;
    String healthCareProgram = "None";
    String comment = "I have a fewer";

    @Test(groups = {"regression"}, description = "This test goes through the whole appointment making process: login, filling in form, book appointment, logout ")
    public void loginWithIncorrectData() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "ThisIsNotAPassword");
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility(facility);
        appointmentPage.applyForHospitalReadmission(applyForHospReadm);
        appointmentPage.selectHealthCareRadio(healthCareProgram);
        appointmentPage.fillDateInput("2024/08/09");
        appointmentPage.fillCommentInput(comment);
        appointmentPage.clickBookAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        HistoryPage historyPage = new HistoryPage(driver);
        historyPage.navigateToHistory();
        Assert.assertTrue(historyPage.checkAppointmentData(facility,applyForHospReadm,healthCareProgram,comment));
        loginPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }
}


