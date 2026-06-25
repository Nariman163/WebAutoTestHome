package pages;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage {

    //Локаторы
    private final By pageTitle = By.className("title");
    private final By productItem = By.className("inventory_item");
    private final By firstProductName = By.cssSelector(".inventory_item:first-child .inventory_item_name");
    private final By firstAddToCartButton = By.cssSelector(".inventory_item:first-child .btn_inventory");
    private final By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
       super(driver);
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

        click(firstAddToCartButton);
    }

    //Переходим в корзину
    public void goToCart() {
        click(cartLink);
    }

}
