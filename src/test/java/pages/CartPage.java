package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private final String empty = "\"В&nbsp;корзине пусто. Чтобы найти товары, используйте поиск или выберите товары из&nbsp;просмотренных ранее:\"";

    @FindBy(className = "user-bar__cart")
    private WebElement cartButton;

    @FindBy(className = "i-textual__plain_limited")
    private WebElement cartIsEmpty;

    @FindBy(className = "digi-products-grid_horde")
    private WebElement itemsResult;

    @FindBy(className = "addtocartform")
    private WebElement addToCartButton;

    @FindBy(className = "goods-table-cell__line_title")
    private WebElement checkItemInCart;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void cartButtonClick() {
        cartButton.click();
    }

    public void checkCartIsEmpty() {
        cartIsEmpty.getText().equals(empty);
    }
    public void checkItemInCart(String item) {
        checkItemInCart.isDisplayed();
        checkItemInCart.getText().equals(item);
    }

    public void itemsResultClick(String item){
       itemsResult.findElement(By.linkText(item.trim())).click();
    }

    public void addToCartButtonClick(){
        addToCartButton.click();
    }
}