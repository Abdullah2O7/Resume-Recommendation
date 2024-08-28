package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {

    public WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    public void clickOn(By by)
    {
        driver.findElement(by).click();
    }
    public void sendText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public String getPageUrl()
    {
        return driver.getCurrentUrl();
    }
}
