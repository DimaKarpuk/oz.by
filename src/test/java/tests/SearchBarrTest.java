package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import testData.Items;

@Owner("KarpukD")
public class SearchBarrTest extends TestBase {
    Items items = new Items();
    MainPage mainPage = new MainPage();

    @DisplayName("Проверка поисковой строки")
    @Test
    void searchTest() {
        String title = "OZ.by — интернет-магазин. Книги, игры, косметика, товары для дома, творчества, подарки, продукты. Доставка по Беларуси.";
        driver.get("https://oz.by/");
        mainPage.refuseCookieClick();
        Assertions.assertTrue(TestBase.driver.getTitle().equals(title));
        mainPage.setSearchBarr(items.getRandomItem());
        mainPage.searchBarrPressEnter();
        mainPage.checkSearchList();
    }
}
