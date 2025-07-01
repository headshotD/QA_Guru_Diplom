package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EnterAlfaBankPage {
    String numberOutMask = "9991112233";
    String numberWithMask = "+7 999 111 22 33";

    private final SelenideElement phoneInputLine = $("[data-test-id='phoneInput']");

    @Step("Проверяем видимость поля ввода телефона")
    public void visiblePhoneInputLine() {
        phoneInputLine.shouldHave(visible);
    }

    @Step("Проверяем маску телефона и автоматическое добавление +7")
    public EnterAlfaBankPage checkMaskPhone() {
        phoneInputLine.setValue(numberOutMask);
        phoneInputLine.shouldHave(value(numberWithMask));
        return new EnterAlfaBankPage();
    }

}
