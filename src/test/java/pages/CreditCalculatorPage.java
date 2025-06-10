package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class CreditCalculatorPage {

    public CreditCalculatorPage checkTitleCreditCalculatorTextTest(String value) {
        $("h1[data-test-id='text']").shouldHave(text(value));
        return this;
    }



    //    public static CreditCalculatorPage openPage() {
//        open("https://alfabank.ru/");
//        return new CreditCalculatorPage();
//    }
    //private final SelenideElement privatePerson = $("[data-test-id='test-retail-link'] p[data-test-id='text']"),
            //credits = $("[data-test-id='link-loans'] p[data-test-id='text']"),
            //creditCalculator = $$("a[href*='calculator'] p[data-test-id='text']").first();
    //awards = $("#menu-item-418");

}
