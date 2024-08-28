package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChatSearchPage extends PageBase {

    By Searchfield = By.className("search-field");
    By SearchButton = By.className("search-button");


    public ChatSearchPage(WebDriver driver) {
        super(driver);
    }
    public void enterYourSearchText(String text){
        sendText(Searchfield,text);
    }
    public void clickOnSearchButton()
    {
        clickOn(SearchButton);
    }

}
