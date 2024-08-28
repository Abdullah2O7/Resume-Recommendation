package Tests;

import Pages.ChatSearchPage;
import Pages.LoginPage;
import Pages.PageBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChatSearchTest extends TestBase{
    LoginPage login;
    ChatSearchPage chatSearchPage;
    PageBase pageBase;
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
    public void SearchInChatField()
    {
        chatSearchPage = new ChatSearchPage(driver);
        chatSearchPage.enterYourSearchText("sherif");
        chatSearchPage.clickOnSearchButton();

        pageBase = new PageBase(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlToBe(expectedURL));

        Assert.assertEquals(pageBase.getPageUrl(), expectedURL);
    }

}
