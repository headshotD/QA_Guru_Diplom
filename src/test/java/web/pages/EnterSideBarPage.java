package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EnterSideBarPage {

    private final SelenideElement enterInAlfaOnline = $("[href*='web.alfabank.ru'] div[data-test-id='grid']");

    public void clickEnterInAlfaOnline() {
        this.enterInAlfaOnline.hover().click();
    }

    public EnterSideBarPage checkVisibleEnterSideBar() {
        enterInAlfaOnline.shouldHave(visible);
        return new EnterSideBarPage();
    }


}
