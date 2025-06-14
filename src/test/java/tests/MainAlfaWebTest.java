package tests;

import config.WebDriverConfig;
import io.qameta.allure.Owner;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

@Tag("AlfaBankWeb")
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
    @DisplayName("Проверяем, что при наведении на меню \"Частным лицам\"открывается меню")
    void openMenuWithHoverInPrivatePersonTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .visiblePrivatePersonMenu();
    }

    @Test
    @DisplayName("Проверка наличия пункта \"Кредиты\" в меню")
    void openMenuWithHoverInPrivatePerson12Test() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .textCredits();
    }

    @Test
    @DisplayName("Открываем страницу кредитный калькулятор")
    void openCreditsCalculatorPageTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.checkTitleCreditCalculatorTextTest();
    }

    @Test
    @DisplayName("Открываем страницу \"Войти\"")
    void openEnterSideBarTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.checkVisibleEnterSideBar();

    }

    @Test
    @DisplayName("Открываем страницу \"Войти\" и выбираем \"Войти в Альфа-онлайн\"")
    void openEnterSideBarAndClickOnAlfaOnlineTest() {
        MainAlfaPage.openPage()
                .clickEnterSideBar();
        enterSideBarPage.clickEnterInAlfaOnline();
        enterAlfaBankPage.visiblePhoneInputLine();
    }
    @Test
    @DisplayName("Открываем страницу \"Стать клиентом\"")
    void openBecomeCustomersPageTest() {
        MainAlfaPage.openPage()
                        .clickBecomeCustomers();
    }
    @Test
    @DisplayName("Открываем страницу заказа карты AlfaOnly")
    void clickOnAlfaOnlyCard() {
        MainAlfaPage.openPage()
                .clickOnAlfaOnlyCard();
        debitCardsPage.textAlfaOnlyCard();
    }

}
