package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnauthorizedPage extends PageBase{
    public UnauthorizedPage(WebDriver driver) {
        super(driver);
    }

    By backToHomeBtn = By.className("back-to-home-button");

    public void clickTheBackToHomeBtn()
    {
        clickOn(backToHomeBtn);
    }
    public WebElement getUnAuthorizedPageTile()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Unauthorized']")));
    }
}
