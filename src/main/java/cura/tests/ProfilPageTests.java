package cura.tests;

import core.DriverManager;
import cura.pages.LoginPage;
import cura.pages.ProfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "check if profile page is loaded")
    public void isProfilPageLoaded() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe","ThisIsNotAPassword");
        ProfilPage profilPage = new ProfilPage(driver);
        profilPage.navigateToProfile();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#profile");
        Assert.assertTrue(profilPage.isLogoutButtonVisible());
    }


}
