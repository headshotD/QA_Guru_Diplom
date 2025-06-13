package pages;

import com.codeborne.selenide.SelenideElement;

import lombok.Data;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MainAlfaPage {
    public static MainAlfaPage openPage() {
        open("https://alfabank.ru/");
        return new MainAlfaPage();
    }

    private final SelenideElement privatePerson = $("[data-test-id='test-retail-link'] p[data-test-id='text']"),
            credits = $("[data-test-id='link-loans'] p[data-test-id='text']"),
            creditCalculator = $$("a[href*='calculator'] p[data-test-id='text']").first(),
            privatePersonMenu = $("[data-test-id='dd-content']"),
            enterSideBar = $("button[data-widget-name='AnalyticsEventSender']"),
            becomeCustomers = $("[data-widget-name='AnalyticsEventSender'][href*='retail/startclient']");

    public MainAlfaPage hoverPrivatePerson() {
        this.privatePerson.hover();
        return this;
    }

    public MainAlfaPage hoverCredits() {
        this.credits.hover();
        return this;
    }
    public void textCredits(String value) {
        credits.shouldHave(text(value));
    }

    public CreditCalculatorPage clickCreditCalculator() {
        creditCalculator.click();
        return new CreditCalculatorPage();
    }

    public MainAlfaPage visiblePrivatePersonMenu() {
        this.privatePersonMenu.shouldBe(visible);
        return this;
    }
    public void clickEnterSideBar() {
        this.enterSideBar.click();
    }
    public void clickBecomeCustomers() {
        this.becomeCustomers.click();
    }

}
