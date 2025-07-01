package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class BecomeCustomers {
    String textAlfaOnly = "Дебетовая карта Alfa Only";

    private final SelenideElement layout = $("[data-widget-name='Layout']");

    @Step("Ищем текст Дебетовая карта Alfa Only на всей странице")
    public void checkTextOnBecomeCustomersPage() {
        layout.shouldHave(text(textAlfaOnly));
    }
}
