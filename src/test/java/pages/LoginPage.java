package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    //Локаторы элементов
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver); //Передаем драйвер в BasePage
    }

    //Метод для открытия страницы логина
    public void open() {

        driver.get("https://www.saucedemo.com/");
    }

    //Метод для выполнения авторизации
    public void login(String user, String password) {
        type(usernameField, user); // используем метод из BasePage
        type(usernameField, password);
        click(loginButton);
    }
}
