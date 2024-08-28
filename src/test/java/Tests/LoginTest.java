package Tests;

import Pages.LoginPage;
import Pages.PageBase;
import Pages.UnauthorizedPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends TestBase{
    LoginPage login;
    UnauthorizedPage unauthorized;
    PageBase pageBase;

    String email = "alice@example.com";
    String password = "Secure1@";
    String expectedURL = "https://espace:espace_staging@resume-recommender.espace.ws/homepage";

    @BeforeMethod
    public void setDriver()
    {
        setUpData();
    }
    @Test
    public void loginWithCorrectCredentials()
    {
        login = new LoginPage(driver);
        login.loginForm(email, password);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        Assert.assertEquals(pageBase.getPageUrl(), expectedURL);
    }
    @Test
    public void loginWithUnAuthorizedUser()
    {
        login.loginForm("bob@example.com", "Password2@");
        Assert.assertEquals(unauthorized.getUnAuthorizedPageTile().getText(),"Unauthorized");

        unauthorized.clickTheBackToHomeBtn();
        Assert.assertEquals(pageBase.getPageUrl(), "https://espace:espace_staging@resume-recommender.espace.ws/login");
    }


    public void setUpData()
    {
        pageBase = new PageBase(driver);
        login = new LoginPage(driver);
        unauthorized = new UnauthorizedPage(driver);
    }
}
