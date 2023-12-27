import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Lesson14Tests {
    private static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by");
        WebElement cookieAgree = driver.findElement(By.id("cookie-agree"));
        cookieAgree.click();
    }

    //Проверка надписей в незаполненных полях "Услуги связи"
    @Test
    public void checkCommunicationServicesFields() {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        WebElement sumField = driver.findElement(By.id("connection-sum"));
        WebElement emailField = driver.findElement(By.id("connection-email"));

        Assertions.assertAll("Communication services fields check",
                () -> assertEquals("Номер телефона", phoneField.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sumField.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"))
        );
    }

    //Проверка надписей в незаполненных полях "Домашний интернет"
    @Test
    public void checkHomeInternetFields() {
        driver.findElement(By.className("select__header")).click();
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")).click();

        WebElement phoneField = driver.findElement(By.id("internet-phone"));
        WebElement sumField = driver.findElement(By.id("internet-sum"));
        WebElement emailField = driver.findElement(By.id("internet-email"));
        Assertions.assertAll("Home internet fields check",
                () -> assertEquals("Номер абонента", phoneField.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sumField.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"))
        );
    }

    //Проверка надписей в незаполненных полях "Рассрочка"
    @Test
    public void checkInstallmentPlanFields() {
        driver.findElement(By.className("select__header")).click();
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p")).click();

        WebElement phoneField = driver.findElement(By.id("score-instalment"));
        WebElement sumField = driver.findElement(By.id("instalment-sum"));
        WebElement emailField = driver.findElement(By.id("instalment-email"));

        Assertions.assertAll("Installment plan fields check",
                () -> assertEquals("Номер счета на 44", phoneField.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sumField.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"))
        );
    }

    //Проверка надписей в незаполненных полях "Задолженность"
    @Test
    public void checkDebtFields() {
        driver.findElement(By.className("select__header")).click();
        driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p")).click();

        WebElement phoneField = driver.findElement(By.id("score-arrears"));
        WebElement sumField = driver.findElement(By.id("arrears-sum"));
        WebElement emailField = driver.findElement(By.id("arrears-email"));

        Assertions.assertAll("Debt fields check",
                () -> assertEquals("Номер счета на 2073", phoneField.getAttribute("placeholder")),
                () -> assertEquals("Сумма", sumField.getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", emailField.getAttribute("placeholder"))
        );
    }

    //Заполнение полей в услугах связи и проверка различных полей и логотипов платежных систем
    @Test
    public void refillCommunicationServicesFields() {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        WebElement moneyToPay = driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

        phoneNumberInput.sendKeys("297777777");
        moneyToPay.sendKeys("3");
        continueButton.click();
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("card-page__card"))));

        WebElement headerPaymentAmount = driver.findElement(By.className("header__payment-amount"));
        WebElement headerPaymentInfo = driver.findElement(By.className("header__payment-info"));
        WebElement cardNumber = driver.findElement(By.className("ng-tns-c47-1"));
        WebElement validity = driver.findElement(By.className("ng-tns-c47-4"));
        WebElement cvc = driver.findElement(By.className("ng-tns-c47-5"));
        WebElement holderName = driver.findElement(By.className("ng-tns-c47-3"));
        WebElement submitButton = driver.findElement(By.className("colored"));
        WebElement masterCardLogo = driver.findElement(By.cssSelector("img[src*='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        WebElement visaLogo = driver.findElement(By.cssSelector("img[src*='assets/images/payment-icons/card-types/visa-system.svg']"));
        WebElement belKartLogo = driver.findElement(By.cssSelector("img[src*='assets/images/payment-icons/card-types/belkart-system.svg"));

        Assertions.assertAll(() -> assertEquals("3.00 BYN", headerPaymentAmount.getText()),
                () -> assertEquals("Оплата: Услуги связи Номер:375297777777", headerPaymentInfo.getText()),
                () -> assertEquals("Номер карты", cardNumber.getText()),
                () -> assertEquals("Срок действия", validity.getText()),
                () -> assertEquals("CVC", cvc.getText()),
                () -> assertEquals("Имя держателя (как на карте)", holderName.getText()),
                () -> assertEquals("Оплатить 3.00 BYN", submitButton.getText()),
                () -> assertTrue(masterCardLogo.isDisplayed()),
                () -> assertTrue(visaLogo.isDisplayed()),
                () -> assertTrue(belKartLogo.isDisplayed())
        );

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
