package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import web.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.*;

@Tag("AlfaBankWeb")
@Tag("All")
@Epic("Главная страница в альфа-банке")
public class MainAlfaWebTest extends TestBase {

    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    private MainAlfaPage mainAlfaPage;
    private CreditCalculatorPage creditCalculatorPage;
    private EnterSideBarPage enterSideBarPage;
    private EnterAlfaBankPage enterAlfaBankPage;
    private DebitCardsPage debitCardsPage;

    @BeforeEach
    public void setUp() {
        mainAlfaPage.openPage();
        creditCalculatorPage = new CreditCalculatorPage();
        enterSideBarPage = new EnterSideBarPage();
        enterAlfaBankPage = new EnterAlfaBankPage();
        debitCardsPage = new DebitCardsPage();

    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем, что при наведении на меню \"Частным лицам\"открывается меню")
    void openMenuWithHoverInPrivatePersonTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .visiblePrivatePersonMenu();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка наличия пункта \"Кредиты\" в меню")
    void openMenuWithHoverAndCheckCreditTextTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .textCredits();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу кредитный калькулятор")
    void openCreditsCalculatorPageTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.checkTitleCreditCalculatorTextTest();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открываем страницу \"Войти\"")
    void openEnterSideBarTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.checkVisibleEnterSideBar();

    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу \"Войти\" и выбираем \"Войти в Альфа-онлайн\"")
    void openEnterSideBarAndClickOnAlfaOnlineTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.clickEnterInAlfaOnline();
        enterAlfaBankPage.visiblePhoneInputLine();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу \"Стать клиентом\"")
    void openBecomeCustomersPageTest() {
        MainAlfaPage.openPage()
                .clickBecomeCustomers();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открываем страницу заказа карты AlfaOnly")
    void clickOnAlfaOnlyCardTest() {
        MainAlfaPage.openPage()
                .clickOnAlfaOnlyCard();
        debitCardsPage.textAlfaOnlyCard();
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Открываем виджет поиска и проверяем, что нашлось значение qa.guru")
    void searchOnTopWidgetTest() {
        MainAlfaPage.openPage()
                .clickOnSearchButton()
                .enterTextInSearchInput()
                .searchResults();
    }

}
