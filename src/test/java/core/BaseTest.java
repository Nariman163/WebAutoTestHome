package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

public abstract class BaseTest {
    // abstract означает, что нельзя создать объект BaseTest напрямую, только наследники
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;// Готовая страница логина, созданная заранее
    protected ProductsPage productsPage; // Готовая страница товаров

    @BeforeEach // Этот метод выполнится перед каждым тестом
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //Настройка драйвера Chrome
        driver = new ChromeDriver(); // Запускаем браузер Chrome
        driver.manage().window().maximize(); // Разворачивает окно на весь экран
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //Создали объект явного ожидания на 20 сек
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);// Создаём объект ProductsPage
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {// Проверяем, что драйвер был создан (избегаем NullPointerException)
            driver.quit();
        }
    }

}
