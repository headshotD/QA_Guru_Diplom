package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import web.config.WebDriverConfig;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;

public class CreditCalculatorPage {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    String maxAmountTest = "99999999";
    String maxAmount = "30 000 000";
    String GosUslugi = "Госуслуги или справка о доходах";

    private final SelenideElement amountInput = $("#creditAmount");
    private final SelenideElement creditCalculatorHeaderText = $("h1[data-test-id='text']");
    private final SelenideElement requiredSecondDocs = $("[data-test-id='second-documents']");

    @Step("Проверяем заголовок калькулятора")
    public void verifyCalculatorTitle() {
        creditCalculatorHeaderText.shouldHave(text(config.creditCalculator()));
    }

    @Step("Проверяем максимальное значение суммы кредита (30 000 000 ₽)")
    public void verifyMaxAmount() {
        amountInput.setValue(maxAmountTest).pressTab();
        amountInput.shouldHave(value(maxAmount));
    }

    @Step("Проверяем список необходимых документов")
    public void verifyRequiredDocuments() {
        requiredSecondDocs.shouldHave(text(GosUslugi));
    }
}