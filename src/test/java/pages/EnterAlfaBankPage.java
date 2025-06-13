package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EnterAlfaBankPage {
    private final SelenideElement phoneInputLine = $("[data-test-id='phoneInput']");

    public EnterAlfaBankPage visiblePhoneInputLine(){
        phoneInputLine.shouldHave(visible);
        return new EnterAlfaBankPage();
    }

}
