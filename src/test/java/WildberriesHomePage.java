import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WildberriesHomePage {
    private final WebDriver driver;
    private final List<Product> products = new ArrayList<>();

    public WildberriesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() throws InterruptedException {
        driver.get("https://www.wildberries.ru/");
        Thread.sleep(3000);
    }

    public void addToCart(int productsCount) throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.className("main-page"))).perform();
        List<WebElement> products = driver.findElements(By.className("product-card__wrapper"));
        for (int i = 0; i < productsCount; i++) {
            WebElement product = products.get(i);
            this.products.add(new Product(product.findElement(By.className("product-card__name")).getText().substring(2),
                    product.findElement(By.className("price__lower-price")).getText()));
            builder.moveToElement(product).perform();
            products.get(i).findElement(By.className("btn-main-sm")).click();

            Thread.sleep(1000);
            if (isPopupDisplayed()) {
                driver.findElement(By.className("j-quick-order-size-fake")).click();
            }

        }
    }

    private boolean isPopupDisplayed() {
        return driver.findElement(By.className("popup__content")).isDisplayed();
    }

    public void goToCart() throws InterruptedException {
        driver.findElement(By.className("navbar-pc__icon--basket")).click();
        Thread.sleep(2000);
        ;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
