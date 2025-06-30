package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import web.config.WebDriverConfig;
import lombok.Data;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Data
public class MainAlfaPage {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    @Step("Открываем главную страницу альфа-банка")
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
            searchInput = $("[data-test-id='search-input']");

    @Step("Переходим в iframe yandex поиска")
    public void searchResults() {
        switchTo().frame($x("//iframe[@data-test-id='ya-site-search-iframe']"));
        $("[class='b-serp-list']").shouldHave(text(config.searchText()));
    }

    @Step("Наводим на раздел Частным лицам")
    public MainAlfaPage hoverPrivatePerson() {
        this.privatePerson.hover();
        return this;
    }

    @Step("Кликаем на иконку лупы")
    public MainAlfaPage clickOnSearchButton() {
        this.searchButtonOnTop.click();
        return this;
    }

    @Step("Вводим текст в поисковую строку и нажимаем Enter")
    public MainAlfaPage enterTextInSearchInput() {
        this.searchInput.setValue(config.searchText()).pressEnter();
        return this;
    }

    @Step("Наводим на подраздел кредиты")
    public MainAlfaPage hoverCredits() {
        this.credits.hover();
        return this;
    }

    @Step("Проверяем заголовок на название Кредиты")
    public void textCredits() {
        credits.shouldHave(text(config.creditTitle()));
    }

    @Step("Кликаем на подзаголовок Кредитный калькулятор")
    public CreditCalculatorPage clickCreditCalculator() {
        creditCalculator.click();
        return new CreditCalculatorPage();
    }

    @Step("Проверяем видимость меню Частным лицам")
    public MainAlfaPage visiblePrivatePersonMenu() {
        this.privatePersonMenu.shouldBe(visible);
        return this;
    }

    @Step("Кликаем на кнопку Войти")
    public void clickEnterSideBar() {
        this.enterSideBar.click();
    }

    @Step("Кликаем на кнопку Стать Клиентом")
    public MainAlfaPage clickBecomeCustomers() {
        this.becomeCustomers.click();
        return this;
    }

}
