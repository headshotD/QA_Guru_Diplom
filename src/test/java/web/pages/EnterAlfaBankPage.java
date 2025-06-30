package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EnterAlfaBankPage {
    private final SelenideElement phoneInputLine = $("[data-test-id='phoneInput']");

    @Step("Проверяем видимость поля ввода телефона")
    public EnterAlfaBankPage visiblePhoneInputLine() {
        phoneInputLine.shouldHave(visible);
        return new EnterAlfaBankPage();
    }

}
