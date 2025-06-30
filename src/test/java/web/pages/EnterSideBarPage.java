package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EnterSideBarPage {

    private final SelenideElement enterInAlfaOnline = $("[href*='web.alfabank.ru'] div[data-test-id='grid']");

    @Step("Наводим на кнопку Войти в Альфа-Онлайн и кликаем")
    public void clickEnterInAlfaOnline() {
        this.enterInAlfaOnline.hover().click();
    }

    @Step("Проверяем видимость элемента в сайдбаре")
    public EnterSideBarPage checkVisibleEnterSideBar() {
        enterInAlfaOnline.shouldHave(visible);
        return new EnterSideBarPage();
    }


}
