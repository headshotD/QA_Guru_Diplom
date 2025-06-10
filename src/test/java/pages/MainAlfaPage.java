package pages;

import com.codeborne.selenide.SelenideElement;

import lombok.Data;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Data
public class MainAlfaPage {
    public static MainAlfaPage openPage() {
        open("https://alfabank.ru/");
        return new MainAlfaPage();
    }
    private final SelenideElement privatePerson = $("[data-test-id='test-retail-link'] p[data-test-id='text']"),
            credits = $("[data-test-id='link-loans'] p[data-test-id='text']"),
            creditCalculator = $$("a[href*='calculator'] p[data-test-id='text']").first();
    //awards = $("#menu-item-418");

    public MainAlfaPage hoverPrivatePerson() {
        this.privatePerson.hover();
        return this;
    }

    public MainAlfaPage hoverCredits() {
        this.credits.hover();
        return this;
    }

    public CreditCalculatorPage clickCreditCalculator() {
        this.creditCalculator.click();
        return new CreditCalculatorPage();
    }

}
