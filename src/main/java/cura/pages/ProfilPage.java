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
        driver.findElement(menuBtnBy).click();
        driver.findElement(profileMenuItemBy).click();
    }

    public boolean isProfilPageLoaded() {
        return driver.findElement(logoutButtonBy).isDisplayed();
    }

}
