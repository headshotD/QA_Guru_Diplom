package web.pages;

import io.qameta.allure.Step;
import web.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class CreditCalculatorPage {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    @Step("Проверяем заголовок Кредитный калькулятор")
    public CreditCalculatorPage checkTitleCreditCalculatorTextTest() {
        $("h1[data-test-id='text']").shouldHave(text(config.creditCalculator()));
        return this;
    }
}
