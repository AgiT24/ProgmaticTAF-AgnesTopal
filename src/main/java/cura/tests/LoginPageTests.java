package cura.tests;

import core.DriverManager;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverManager {

    @Test(groups = {"regression"}, description = "Checks whether the page sends an error message in case of incorrect username")
    public void loginWithIncorrectUsername() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doey", "ThisIsNotAPassword");
        Assert.assertTrue(driver.getPageSource().contains("Login failed!"));
    }

    @Test(groups = {"regression"}, description = "Checks whether the page sends an error message in case of incorrect password")
    public void loginWithIncorrectPassword() {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("John Doe", "Password");
        Assert.assertTrue(driver.getPageSource().contains("Login failed!"));
    }

}
