package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Data
public class CreditCalculatorPage {
    public static CreditCalculatorPage openPage() {
        open("https://alfabank.ru/");
        return new CreditCalculatorPage();
    }

    public CreditCalculatorPage checkTitleTextTest(String value) {
        $("h1[data-test-id='text']").shouldHave(text(value));
        return this;
    }
    String title = "Кредитный калькулятор";

    private final SelenideElement privatePerson = $("[data-test-id='test-retail-link'] p[data-test-id='text']"),
            credits = $("[data-test-id='link-loans'] p[data-test-id='text']"),
            creditCalculator = $$("a[href*='calculator'] p[data-test-id='text']").first();
    //awards = $("#menu-item-418");

}
