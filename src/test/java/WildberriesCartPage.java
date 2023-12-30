import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WildberriesCartPage {
    private final WebDriver driver;

    public WildberriesCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkProductsNames(List<Product> products) {
        List<WebElement> cartProducts = driver.findElements(By.className("accordion__list-item"));

        for (int i = 0, j = products.size() - 1; i < products.size(); i++, j--) {
            WebElement cartProduct = cartProducts.get(i);
            Product expectedProduct = products.get(j);

            Assertions.assertEquals(expectedProduct.getName(), cartProduct.findElement(By.className("good-info__good-name")).getText());
        }
    }

    public void checkProductsPrices(List<Product> products) {
        List<WebElement> cartProducts = driver.findElements(By.className("accordion__list-item"));

        for (int i = 0, j = products.size() - 1; i < products.size(); i++, j--) {
            WebElement cartProduct = cartProducts.get(i);
            Product expectedProduct = products.get(j);

            Assertions.assertEquals(expectedProduct.getPrice(), cartProduct.findElement(By.className("list-item__price-new")).getText());
        }
    }

    public void checkProductsCount(List<Product> products) {
        String[] bottomLineWithCount = driver.findElement(By.className("b-top__count")).getText().split(" ");
        int productsCount = Integer.parseInt(bottomLineWithCount[1]);


        Assertions.assertEquals(products.size(), productsCount);

    }

    private double convertPriceToDouble(String price) {
        String priceWithoutCurrency = price.replaceAll("[^\\d.,]", "");
        return Double.parseDouble(priceWithoutCurrency.replace(",", "."));
    }

    public void checkTotalPrice(List<Product> products) {
        double cartPageTotalPrice = convertPriceToDouble(driver.findElement(By.className("b-right")).getText());
        double productsTotalPrice = products.stream()
                .mapToDouble(product -> convertPriceToDouble(product.getPrice()))
                .sum();

        Assertions.assertEquals(cartPageTotalPrice, productsTotalPrice);
    }
}
