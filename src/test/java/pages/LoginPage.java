package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage { // extends — наследование: LoginPage получает все методы BasePage


    //Локаторы элементов
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    // Конструктор: принимает driver и передаёт его в родительский класс BasePage
    public LoginPage(WebDriver driver) {
        super(driver); // Вызов конструктора родителя (BasePage)
    }

    //Метод для открытия страницы логина
    public void open() {

        driver.get("https://www.saucedemo.com/");
    }

    //Метод для выполнения авторизации
    public void login(String username, String password) {
        type(usernameField, username); // используем метод из BasePage
        type(passwordField, password);
        click(loginButton);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
