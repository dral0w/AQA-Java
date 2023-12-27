import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lesson13Test {
    private static WebDriver driver;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        WebElement cookieAgree = driver.findElement(By.id("cookie-agree"));
        cookieAgree.click();
    }

    //Проверить название указанного блока
    @Test
    public void testBlockTitle() {
        WebElement blockTitle = driver.findElement(By.className("pay__wrapper"));
        assertTrue(blockTitle.isDisplayed(), "Блок с названием не найден");
        assertEquals("Онлайн пополнение\n" + "без комиссии", blockTitle.findElement(By.tagName("h2")).getText());
    }

    //Проверить наличие логотипов платёжных систем
    @Test
    public void testPaymentLogos() {
        WebElement logos = driver.findElement(By.className("pay__partners"));
        assertTrue(logos.findElement(By.cssSelector("img[alt='Visa']")).isDisplayed());
        assertTrue(logos.findElement(By.cssSelector("img[alt='Verified By Visa']")).isDisplayed());
        assertTrue(logos.findElement(By.cssSelector("img[alt='MasterCard']")).isDisplayed());
        assertTrue(logos.findElement(By.cssSelector("img[alt='MasterCard Secure Code']")).isDisplayed());
        assertTrue(logos.findElement(By.cssSelector("img[alt='Белкарт']")).isDisplayed());
        assertTrue(logos.findElement(By.cssSelector("img[alt='МИР']")).isDisplayed());
    }

    //Проверить работу ссылки «Подробнее о сервисе»
    @Test
    public void testServiceDetailsLink() {
        WebElement serviceDetailsLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        serviceDetailsLink.click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Ссылка 'Подробнее о сервисе' не работает");
        assertTrue(driver.findElement(By.className("container-fluid")).isDisplayed());
    }

    //Заполнить поля и проверить работу кнопки «Продолжить»
    @Test
    public void testOnlineFill() {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        WebElement moneyToPay = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

        phoneNumberInput.sendKeys("297777777");
        moneyToPay.sendKeys("3");
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement frame = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(frame);

        assertTrue(driver.findElement(By.tagName("app-payment-container")).isEnabled());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

