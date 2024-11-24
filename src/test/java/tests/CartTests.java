package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.MainPage;
import testData.Items;

import static io.qameta.allure.Allure.step;


public class CartTests extends TestBase {
    CartPage cartPage = new CartPage();
    MainPage mainPage = new MainPage();
    Items items = new Items();
    String item = items.getRandomItem();
    private final String title = "Оформление заказа OZ.by";

    @DisplayName("Проверка что в корзине нет товара")
    @Test
    void cartIsEmptyTest() {
        step("Открываем страницу корзина",() -> {
            driver.get("https://oz.by/checkout/");
        });
        step("Проверяем title страницы", () -> {
            Assertions.assertTrue(driver.getTitle().equals(title));
        });
        step("Проверяем что в корзине нет товара", () -> {
            cartPage.checkCartIsEmpty();
        });

    }

    @Disabled
    @DisplayName("Тест на добавление товара в корзину")
    @Test
    void addToCartTest(){
        step("Открываем страницу корзина",() -> {
            driver.get("https://oz.by/checkout/");
        });
        step("Проверяем title страницы", () -> {
            Assertions.assertTrue(driver.getTitle().equals(title));
        });
        step("Проверяем что в корзине нет товара", () -> {
            cartPage.checkCartIsEmpty();
        });
        step("Ищем товар " + item + " через пойсковую строку", () -> {
            Thread.sleep(2000);
            mainPage.setSearchBarr(item);
            mainPage.searchBarrPressEnter();
        });
        step("Переходим на страницу товара " + item , () -> {
            cartPage.itemsResultClick(item);
            mainPage.refuseCookieClick();
        });
        step("Добовляем товар в корзину", () -> {
            cartPage.addToCartButtonClick();
        });
        step("проверяем что в корзине есть товар", () -> {
            Thread.sleep(2000);
            cartPage.cartButtonClick();
            Thread.sleep(2000);
            cartPage.checkItemInCart(item);
        });
    }
}
