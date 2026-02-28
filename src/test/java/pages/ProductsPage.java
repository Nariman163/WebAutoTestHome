package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    //Локаторы
    private By pageTitle = By.className("title");
    private By productItem = By.className("inventory_item");
    private By firstProductName = By.cssSelector(".inventory_item:first-child .inventory_item_name");
    private By firstAddToCartButton = By.cssSelector(".inventory_item:first-child .btn_inventory");
    private By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Ждем загрузки страницы
    public void waitPageLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
    }

    //Проверяем что товары есть
    public boolean productsExist() {
        return driver.findElements(productItem).size() > 0;
    }

    //Получаем название первого товара
    public String getFirstProductName() {
        return driver.findElement(firstProductName).getText();
    }

    //Добавлям первый товар в корзину
    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartButton).click();
    }

    //Переходим в корзину
    public void goToCart() {
        driver.findElement(cartLink).click();
    }

}
