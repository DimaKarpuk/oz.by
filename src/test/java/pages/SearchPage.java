package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {
    @FindBy(css = (".digi-products-grid.digi-products-grid_horde"))
    private WebElement listItems;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }
}
