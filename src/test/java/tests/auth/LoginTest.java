package tests.auth;

import core.BasePage;
import core.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Успешный вход с корректными данными")
    public void shouldLoginWithValidCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.waitPageLoaded();
        assertEquals("Products", productsPage.getPageTitle(), "Заголовок страницы должен быть 'Products' после успешного входа");
    }

    @Test
    @DisplayName("Ошибка при неверном пароле")
    public void shouldShowErrorWithInvalidPassword() {
        loginPage.open();
        loginPage.login("standard_user", "wrong_password");
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedError, loginPage.getErrorMessage(),
                "Текст ошибки должен соответствовать ожидаемому");
    }

    @Test
    @DisplayName("Кнопка логина отображается при открытии страницы")
    public void shouldSeeLoginButtonOnOpen() {
        loginPage.open();
        // Проверяем, что кнопка логина видна (используя метод isLoginButtonDisplayed из LoginPage, который мы добавим)
        assertTrue(loginPage.isLoginButtonDisplayed(), "Кнопка логина должна быть видна");
    }
}
