package web.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.pages.*;

@Tag("AlfaBankWeb")
@Tag("All")
@Owner("ONamozov")
@Epic("Главная страница в альфа-банке")
@DisplayName("Тесты на главной странице альфа-банка")
public class MainAlfaWebTest extends TestBase {

    EnterAlfaBankPage enterAlfaBankPage = new EnterAlfaBankPage();
    CreditCalculatorPage creditCalculatorPage = new CreditCalculatorPage();
    EnterSideBarPage enterSideBarPage = new EnterSideBarPage();
    BecomeCustomersPage becomeCustomers = new BecomeCustomersPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем, что при наведении на меню \"Частным лицам\"открывается меню")
    void openMenuWithHoverInPrivatePersonTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .visiblePrivatePersonMenu();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка наличия пункта \"Кредиты\" в меню")
    void openMenuWithHoverAndCheckCreditTextTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .textCredits();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу кредитный калькулятор")
    void openCreditsCalculatorPageTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.verifyCalculatorTitle();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем максимальную сумму кредита на странице Кредитный калькулятор")
    void openCreditsCalculatorAndCheckMaxSumTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.verifyMaxAmount();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем отображения текста Госуслуги или справка о доходах если сумма кредита больше 300.000")
    void openCreditsCalculatorAndCheckGosUslugiTextTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.verifyRequiredDocuments();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Открываем страницу \"Войти\"")
    void openEnterSideBarTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.checkVisibleEnterSideBar();

    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу \"Войти\" и выбираем \"Войти в Альфа-онлайн\", проверяем, что открылась страница входа")
    void openEnterSideBarAndClickOnAlfaOnlineTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.clickEnterInAlfaOnline();
        enterAlfaBankPage.visiblePhoneInputLine();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверяем маску телефона на странице \"Войти в Альфа-онлайн\"")
    void checkMaskPhoneAtAlfaOnlinePageTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.clickEnterInAlfaOnline();
        enterAlfaBankPage.checkMaskPhone();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открываем страницу \"Стать клиентом\"")
    void openBecomeCustomersPageTest() {
        MainAlfaPage.openPage()
                .clickBecomeCustomers();
        becomeCustomers.checkTextOnBecomeCustomersPage();

    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Открываем виджет поиска и проверяем, что нашлось значение qa.guru")
    void searchOnTopWidgetTest() {
        MainAlfaPage.openPage()
                .clickOnSearchButton()
                .enterTextInSearchInput()
                .searchResults();
    }

}
