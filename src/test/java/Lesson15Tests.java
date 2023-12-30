import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lesson15Tests {

    private static WebDriver driver;
    private WildberriesHomePage homePage;
    private WildberriesCartPage cartPage;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void init() {
        homePage = new WildberriesHomePage(driver);
        cartPage = new WildberriesCartPage(driver);
    }

    @Test
    @DisplayName("Добавление товаров в корзину и проверка корзины")
    public void testAddToCartAndCheckCart() throws InterruptedException {
        homePage.open();
        homePage.addToCart(5);

        homePage.goToCart();

        cartPage.checkProductsNames(homePage.getProducts());
        cartPage.checkProductsPrices(homePage.getProducts());
        cartPage.checkProductsCount(homePage.getProducts());
        cartPage.checkTotalPrice(homePage.getProducts());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
