package cura.tests;

import core.DriverManager;
import cura.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTests extends DriverManager {
    @Test
    public void isMakeAppointmentClickable() {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        HomePage homePage = new HomePage(driver);
        homePage.clickMakeAppointment();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");

    }

}
