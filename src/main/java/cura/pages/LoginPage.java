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

    public void fillUserNameInput(String username) {
        WebElement usernameInputField = driver.findElement(usernameInputBy);
        usernameInputField.sendKeys(username);
    }

    public void fillPasswordInput(String password) {
        WebElement passwordInputField = driver.findElement(passwordInputBy);
        passwordInputField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();
    }


}
