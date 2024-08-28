package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {

    HomePage homePage;
    PageBase pageBase;
    LoginPage login;

    String email = "alice@example.com";
    String password = "Secure1@";
    String expectedURL = "https://espace:espace_staging@resume-recommender.espace.ws/homepage";

    @BeforeMethod
    public void loginWithCorrectCredentials()
    {
        login = new LoginPage(driver);
        login.loginForm(email, password);
    }


    @Test
    public void logout(){
        homePage = new HomePage(driver);
        homePage.clickOnLogoutButton();
        pageBase = new PageBase(driver);
        Assert.assertEquals(login.getLogoutMessage(),"Logged out successfully");

    }
}
