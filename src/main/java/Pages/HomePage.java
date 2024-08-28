package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {

    By Searchfield = By.className("search-field");
    By SearchButton = By.className("search-button");
    private final By loginButton = By.xpath("//img[@alt='logout icon']");


    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void enterYourSearchText(String text){
        sendText(Searchfield,text);
    }
    public void clickOnSearchButton()
    {
        clickOn(SearchButton);
    }

    public void clickOnLogoutButton(){
        clickOn(loginButton);
    }

}
