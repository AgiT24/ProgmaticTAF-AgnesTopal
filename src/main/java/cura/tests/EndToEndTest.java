package cura.tests;

import core.DriverManager;
import cura.pages.AppointmentPage;
import cura.pages.HomePage;
import cura.pages.LoginPage;
import cura.pages.ProfilPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverManager {

    @Test(description = "This test goes through the whole appointment making process: login, filling in form, book appointment, logout ")
    public void loginWithIncorrectData() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("John Doe");
        loginPage.fillPasswordInput("ThisIsNotAPassword");
        loginPage.clickLogin();
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.applyForHospitalReadmission(true);
        appointmentPage.selectHealthCareRadio("None");
        appointmentPage.fillDateInput("2024/08/09");
        appointmentPage.fillCommentInput("I have a fewer");
        appointmentPage.clickBookAppointmentBtn();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        logOutButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
    }
}


