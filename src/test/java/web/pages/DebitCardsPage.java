package web.pages;

import com.codeborne.selenide.SelenideElement;
import web.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DebitCardsPage {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);

    private final SelenideElement debitCardAlfaOnly = $("div h2 [href*='alfacard-premium/?platformId']");

    public DebitCardsPage textAlfaOnlyCard(){
        debitCardAlfaOnly.shouldHave(text(config.textDebitCardAlfaOnly()));
        return new DebitCardsPage();
    }
}
