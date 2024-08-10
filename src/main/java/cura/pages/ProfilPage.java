package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProfilPage {
    private final By menuBtnBy = By.id("menu-toggle");
    private final By profileMenuItemBy = By.linkText("Profile");
    private final By logoutButtonBy = By.linkText("Logout");

    private WebDriver driver;

    public ProfilPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToProfile() {
        System.out.println("Opening Menu");
        driver.findElement(menuBtnBy).click();
        System.out.println("Clicking on Profile");
        driver.findElement(profileMenuItemBy).click();
    }

    public boolean isLogoutButtonVisible() {
        System.out.println("Checking if logout button is visible");
        return driver.findElement(logoutButtonBy).isDisplayed();
    }

}
