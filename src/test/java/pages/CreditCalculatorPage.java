package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class CreditCalculatorPage {

    public CreditCalculatorPage checkTitleCreditCalculatorTextTest(String value) {
        $("h1[data-test-id='text']").shouldHave(text(value));
        return this;
    }
}
