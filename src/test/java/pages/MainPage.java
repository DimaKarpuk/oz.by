package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(id = "top-s")
    private WebElement searchInput;

    @FindBy(css = "[data-action = 'click->cookie-dialog#handleRejectClick']")
    private WebElement refuseCookie;

    @FindBy(className = "digi-wrapper")
    private WebElement checkSearchList;

    public MainPage() {
        PageFactory.initElements(driver,this);
    }

    public void setSearchBarr(String item) {

        searchInput.sendKeys(item);
    }
    public void searchBarrPressEnter() {
        searchInput.sendKeys(Keys.ENTER);
    }

    public void refuseCookieClick() {
        refuseCookie.click();
    }

    public void checkSearchList(){
        Assertions.assertFalse(checkSearchList.getText().isEmpty());
    }
}
