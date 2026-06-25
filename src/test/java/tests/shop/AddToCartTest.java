package tests.shop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class AddToCartTest {

    @Test
    public void testAddProductionToCart(){
        WebDriverManager.chromedriver().setup(); // Проверка версии Chrome
        WebDriver driver = new ChromeDriver(); // Создаем объект класса ChromeDriver

        //Создаем объект wait, который будем использовать для ожидания элементов
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Открываем страницу логина
            driver.get("https://www.saucedemo.com/");

            // Авторизуемся, находим поле username и вводим логин (type="text" data-test="username" id="user-name" name="user-name")
            WebElement usernameField = driver.findElement(By.id("user-name"));
            usernameField.sendKeys("standard_user");

            // Аналогично с паролем
            WebElement passField = driver.findElement(By.id("password"));
            passField.sendKeys("secret_sauce");

            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Ждем, когда страница товаров загрузится(Появляется заголовок "Products")
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

            // Проверяем, что товары присутствуют( находим все элементы с классом inventory_item)
            List<WebElement> products = driver.findElements(By.className("inventory_item"));
            assertTrue(products.size() > 0, "Список товаров пуст");//Проверка на истинность

            // Запоминаем название первого товара
            WebElement firstProductName = driver.findElement(By.cssSelector(".inventory_item:first-child .inventory_item_name"));
            String expectedProductName = firstProductName.getText();
            System.out.println("Добавляем товар: " + expectedProductName);

            // Нажимаем кнопку Add cart у первого товара
            WebElement addToCartName = driver.findElement(By.cssSelector(".inventory_item:first-child .btn_inventory"));
            addToCartName.click();

            // Проверяем, что значок корзины обновился
            WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
            String badgeText = cartBadge.getText();
            assertEquals("1", badgeText, "Количество товаров в корзине = 1");

            // Переходим в корзину
            WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
            cartLink.click();

            // Ждём загрузки страницы корзины
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

            // Проверяем, что в корзине лежит наш товар
            WebElement cartItemName = driver.findElement(By.className("inventory_item_name"));
            String actualProductName = cartItemName.getText();
            assertEquals(expectedProductName, actualProductName,
                    "Название товара в корзине не совпадает с добавленным");

            // Дополнительно проверяем, что есть кнопка удаления
            WebElement removeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_button")));
            assertTrue(removeButton.isDisplayed(), "Кнопка удаления не отображается");

            System.out.println("Тест успешно пройден! Товар добавлен в корзину.");
        } finally {
            driver.quit();
        }
    }
}
