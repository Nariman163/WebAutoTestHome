package tests.shop;

import core.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddToCartTest extends BaseTest {

    @Test
    @DisplayName("Добавление первого товара в корзину и проверка счётчика")
    public void shouldAddFirstProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitPageLoaded();

        // Запоминаем название первого товара
        String expectedName = productsPage.getFirstProductName();

        // Добавляем первый товар в корзину
        productsPage.addFirstProductToCart();

        // Проверяем, что значок корзины показывает "1"
        assertEquals("1", productsPage.getCartBadgeCount(),
                "После добавления одного товара счётчик должен показывать 1");

        // Переходим в корзину
        productsPage.goToCart();

        // Проверяем, что URL содержит cart.html (пока простейшая проверка; позже сделаем CartPage)
        assertTrue(driver.getCurrentUrl().contains("cart.html"),
                "URL должен содержать 'cart.html' после перехода в корзину");
    }
}