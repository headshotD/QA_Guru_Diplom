package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreditCalculatorPage;
import pages.EnterAlfaBankPage;
import pages.EnterSideBarPage;
import pages.MainAlfaPage;

public class MainAlfaWebTest extends TestBase {

    private MainAlfaPage mainAlfaPage;
    private CreditCalculatorPage creditCalculatorPage;
    private EnterSideBarPage enterSideBarPage;
    private EnterAlfaBankPage enterAlfaBankPage;

    @BeforeEach
    public void setUp() {
        mainAlfaPage.openPage();
        creditCalculatorPage = new CreditCalculatorPage();
        enterSideBarPage = new EnterSideBarPage();
        enterAlfaBankPage = new EnterAlfaBankPage();
    }

    String CreditTitle = "Кредиты";
    String CreditCalculator = "Кредитный калькулятор";

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
                .textCredits(CreditTitle);
    }

    @Test
    @DisplayName("Открываем страницу кредитный калькулятор")
    void openCreditsCalculatorPageTest() {
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
        creditCalculatorPage.checkTitleCreditCalculatorTextTest(CreditCalculator);
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
}
