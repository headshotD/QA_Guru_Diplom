package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CreditCalculatorPage;
import pages.MainAlfaPage;

public class OpenCreditsCalculatorTest extends TestBase{
    private MainAlfaPage mainAlfaPage;
    private CreditCalculatorPage creditCalculatorPage;
    @BeforeEach
    public void setUp() {
        mainAlfaPage.openPage();

    }
    @Test
    void openCreditsCalculatorTest(){
        MainAlfaPage.openPage()
                .hoverPrivatePerson()
                .hoverCredits()
                .clickCreditCalculator();
                creditCalculatorPage.checkTitleTextTest("Кредитный калькулятор");
    }
}
