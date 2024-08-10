package cura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final By usernameInputBy = By.id("txt-username");
    private final By passwordInputBy = By.id("txt-password");
    private final By loginButtonBy = By.id("btn-login");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String username, String password) {
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("Filling username input field with: "+username);
        WebElement usernameInputField = driver.findElement(usernameInputBy);
        usernameInputField.sendKeys(username);
        System.out.println("Filling password input field with: "+password);
        WebElement passwordInputField = driver.findElement(passwordInputBy);
        passwordInputField.sendKeys(password);
        System.out.println("Clicking on Login button");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
    }

    public void logout() {
        System.out.println("Opening Menu");
        WebElement menuButton = driver.findElement(By.id("menu-toggle"));
        menuButton.click();
        System.out.println("Clicking on Logout");
        WebElement logOutButton = driver.findElement(By.linkText("Logout"));
        logOutButton.click();
    }
}
