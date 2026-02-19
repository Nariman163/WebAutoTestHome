import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    public void testLogin(){
        //Настойка драйвера
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Открыть страницу
            driver.get("https://the-internet.herokuapp.com/login");

            // Найти поле ввода имени пользователя id = username
            WebElement usernameField = driver.findElement(By.id("username"));
            //Вводим текст
            usernameField.sendKeys("tomsmith");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("SuperSecretPassword!");

            //Найти кнопку входа по классу "radius"(class="radius")
            WebElement loginButton = driver.findElement(By.className("radius"));
            loginButton.click(); //Кликаем по кнопке

            //Проверить, что мы успешно зашли
            //На стрнице после входа есть элемент с классом "flash success"
            WebElement successMessage = driver.findElement(By.className("flash"));
            String messageText = successMessage.getText();
            assertTrue(messageText.contains("You logged into a secure area!"), "Сообщение об успехе не найдено или неверно");
        } finally {
            driver.quit();
        }
    }
}
