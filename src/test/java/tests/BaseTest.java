package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    // Объявляем переменные, которые будут доступны во всех классах-наследниках
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //Настройка драйвера Chrome
        driver = new ChromeDriver(); // Экземпляр браузера
        driver.manage().window().maximize(); // Разворачивает окно на весь экран
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); //Создали объект явного ожидания на 20 сек
    }

    @AfterEach
    public void tearDown() {
        if (driver != null); {
            driver.quit();
        }
    }

}
