package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginBtn = By.className("loginButton");
    private final By logoutMessage = By.xpath("//div[text()='Logged out successfully']");

    public void loginForm(String email, String password)
    {
        sendText(emailField,email);
        sendText(passwordField, password);
        clickOn(loginBtn);
    }

    public String getLogoutMessage(){
        return getText(logoutMessage);
    }
}
