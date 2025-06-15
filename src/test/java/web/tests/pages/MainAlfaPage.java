package web.tests.pages;

import com.codeborne.selenide.SelenideElement;
import config.WebDriverConfig;
import lombok.Data;
import org.aeonbits.owner.ConfigFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MainAlfaPage {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    public static MainAlfaPage openPage() {
        open("https://alfabank.ru/");
        return new MainAlfaPage();
    }

    private final SelenideElement privatePerson = $("[data-test-id='test-retail-link'] p[data-test-id='text']"),
            credits = $("[data-test-id='link-loans'] p[data-test-id='text']"),
            creditCalculator = $$("a[href*='calculator'] p[data-test-id='text']").first(),
            privatePersonMenu = $("[data-test-id='dd-content']"),
            enterSideBar = $("button[data-widget-name='AnalyticsEventSender']"),
            becomeCustomers = $("[data-widget-name='AnalyticsEventSender'][href*='retail/startclient']"),
            searchButtonOnTop = $("[data-test-id='test-ya-button']"),
            searchInput = $("[data-test-id='search-input']"),
            alfaOnlyCard = $x("//*[text() = 'Ваш премиальный сервис']").shouldBe(interactable, Duration.ofSeconds(3));

    public void searchResults() {
        switchTo().frame($x("//iframe[@data-test-id='ya-site-search-iframe']"));
        $("[class='b-serp-list']").shouldHave(text(config.searchText()));
    }

    public MainAlfaPage hoverPrivatePerson() {
        this.privatePerson.hover();
        return this;
    }

    public MainAlfaPage clickOnSearchButton() {
        this.searchButtonOnTop.click();
        return this;
    }

    public MainAlfaPage enterTextInSearchInput() {
        this.searchInput.setValue(config.searchText()).pressEnter();
        return this;
    }

    public MainAlfaPage clickOnAlfaOnlyCard() {
        this.alfaOnlyCard.click();
        return this;
    }

    public MainAlfaPage hoverCredits() {
        this.credits.hover();
        return this;
    }

    public void textCredits() {
        credits.shouldHave(text(config.creditTitle()));
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
