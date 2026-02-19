import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstWebTest {

    @Test
    public void testPageTitle() {
        // Автоматически скачивает и настраивает драйвер для Chrome
        WebDriverManager.chromedriver().setup();

        // Создаём экземпляр драйвера (откроется браузер)
        // Driver - это объект класса ChromeDriver, а WebDriver это интерфейс(тип)
        WebDriver driver = new ChromeDriver();

        try {
            // Переходим на сайт
            driver.get("https://www.example.com");

            // Получаем заголовок страницы
            String actualTitle = driver.getTitle();
            String expectedTitle = "Example Domain";

            // Проверяем, что заголовок соответствует ожидаемому, если значения expectedTitle и actualTitle не равны - тест упадет
            assertEquals(expectedTitle, actualTitle, "Заголовок страницы не совпадает");
        } finally {
            // Закрываем браузер
            driver.quit();
        }
    }
}