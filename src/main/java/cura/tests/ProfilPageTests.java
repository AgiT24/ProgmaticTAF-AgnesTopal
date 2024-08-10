package cura.tests;

import core.DriverManager;
import cura.pages.HomePage;
import cura.pages.LoginPage;
import cura.pages.ProfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "check if profil page is loaded")
    public void isProfilPageLoaded() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        login();
        ProfilPage profilPage = new ProfilPage(driver);
        profilPage.navigateToProfile();
        Assert.assertTrue(profilPage.isProfilPageLoaded());
    }

    public void login(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("John Doe");
        loginPage.fillPasswordInput("ThisIsNotAPassword");
        loginPage.clickLogin();
    }
}
