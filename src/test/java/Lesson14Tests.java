import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Lesson14Tests {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by");
        WebElement cookieAgree = driver.findElement(By.id("cookie-agree"));
        cookieAgree.click();
    }

    //Проверка надписей в незаполненных полях
    @ParameterizedTest
    @MethodSource("getServiceFields")
    void checkServiceFields(ServiceType serviceType, String phonePlaceholder, String sumPlaceholder, String emailPlaceholder) {
        selectServiceType(serviceType);

        WebElement phoneField = driver.findElement(By.id(serviceType.getPhoneFieldId()));
        WebElement sumField = driver.findElement(By.id(serviceType.getSumFieldId()));
        WebElement emailField = driver.findElement(By.id(serviceType.getEmailFieldId()));

        assertAll("Service fields check",
                () -> assertEquals(phonePlaceholder, phoneField.getAttribute("placeholder")),
                () -> assertEquals(sumPlaceholder, sumField.getAttribute("placeholder")),
                () -> assertEquals(emailPlaceholder, emailField.getAttribute("placeholder"))
        );
    }

    //Заполнение полей в услугах связи и проверка различных полей и логотипов платежных систем
    @Test
    void refillServiceFields() {
        WebElement phoneNumberInput =  driver.findElement(By.id("connection-phone"));
        WebElement moneyToPay =  driver.findElement(By.id("connection-sum"));
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));

        phoneNumberInput.sendKeys("297777777");
        moneyToPay.sendKeys("3");
        continueButton.click();
        driver.switchTo().frame(driver.findElement(By.className("bepaid-iframe")));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("card-page__card"))));

        WebElement headerPaymentAmount = driver.findElement(By.className("header__payment-amount"));
        WebElement headerPaymentInfo = driver.findElement(By.className("header__payment-info"));
        WebElement cardNumber = driver.findElement(By.className("ng-tns-c47-1"));
        WebElement validity = driver.findElement(By.className("ng-tns-c47-4"));
        WebElement cvc = driver.findElement(By.className("ng-tns-c47-5"));
        WebElement holderName = driver.findElement(By.className("ng-tns-c47-3"));
        WebElement submitButton = driver.findElement(By.className("colored"));
        WebElement masterCardLogo = driver.findElement(By.cssSelector("[class*='cards-brands'] img[src*='mastercard']"));
        WebElement visaLogo = driver.findElement(By.cssSelector("[class*='cards-brands'] img[src*='visa-system']"));
        WebElement belKartLogo = driver.findElement(By.cssSelector("[class*='cards-brands'] img[src*='belkart-system"));

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

    private static Stream<Arguments> getServiceFields() {
        return Stream.of(
                Arguments.of(ServiceType.COMMUNICATION, "Номер телефона", "Сумма", "E-mail для отправки чека"),
                Arguments.of(ServiceType.INTERNET_HOME, "Номер абонента", "Сумма", "E-mail для отправки чека"),
                Arguments.of(ServiceType.INSTALLMENT_PLAN, "Номер счета на 44", "Сумма", "E-mail для отправки чека"),
                Arguments.of(ServiceType.DEBT, "Номер счета на 2073", "Сумма", "E-mail для отправки чека")
        );
    }

    private void selectServiceType(ServiceType serviceType) {
        driver.findElement(By.className("select__header")).click();
        driver.findElement(By.xpath("//p[contains(@class,'select__option') and contains(text(),'" + serviceType.getName() + "')]")).click();
    }

    private enum ServiceType {
        COMMUNICATION("Услуги связи", "connection-phone", "connection-sum", "connection-email"),
        INTERNET_HOME("Домашний интернет", "internet-phone", "internet-sum", "internet-email"),
        INSTALLMENT_PLAN("Рассрочка", "score-instalment", "instalment-sum", "instalment-email"),
        DEBT("Задолженность", "score-arrears", "arrears-sum", "arrears-email");

        private final String name;
        private final String phoneFieldId;
        private final String sumFieldId;
        private final String emailFieldId;

        ServiceType(String name, String phoneFieldId, String sumFieldId, String emailFieldId) {
            this.name = name;
            this.phoneFieldId = phoneFieldId;
            this.sumFieldId = sumFieldId;
            this.emailFieldId = emailFieldId;
        }

        public String getName() {
            return name;
        }

        public String getPhoneFieldId() {
            return phoneFieldId;
        }

        public String getSumFieldId() {
            return sumFieldId;
        }

        public String getEmailFieldId() {
            return emailFieldId;
        }
    }
}
