package cura.tests;

import core.DriverManager;
import cura.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverManager {

    @Test (description = "Checks whether the page sends an error message in case of incorrect login data")
    public void loginWithIncorrectData () {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput("John Doe");
        loginPage.fillPasswordInput("incorrectpw");
        loginPage.clickLogin();
        Assert.assertTrue(driver.getPageSource().contains("Login failed!"));
    }

}
