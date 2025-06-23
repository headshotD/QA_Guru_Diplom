package mobile.tests.emulationAndroid;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mobile.tests.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("AlfaBankAndroidEmulation")
@Epic("Экран входа в приложении")
public class AlfaBankStartScreenTest extends TestBase {

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    void checkTitleOnWelcomeScreenTest() {
        step("Проверка тайтла на экране входа", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
        });
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.TRIVIAL)
    void checkClickableFalseOnEnterButtonTest() {
        step("Проверка, что кнопка зайти задизейблена если поле ввода не заполнено", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+7");
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("clickable", "false"));
        });
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    void checkShouldHaveButtonEnterTest() {
        step("Проверка, что у кнопки входа текст Зайти", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("text", "Зайти"));
        });
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    public void checkBadHuntWithBadRuNumberTest() {
        step("Проверка ввода некорректного телефона", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+71111111111");
            $(By.id("ru.alfabank.mobile.android:id/text_field_hint"))
                    .shouldHave(text("Некорректный номер телефона"));
        });
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    public void checkBadHuntWithInoNumberTest() {
        step("Проверка ввода некорректного иностранного телефона", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("12312321321");
            $(By.id("ru.alfabank.mobile.android:id/button_container"))
                    .click();
            $(By.id("ru.alfabank.mobile.android:id/text_field_hint"))
                    .shouldHave(text("Кажется, это иностранный номер. Введите номер российского оператора"));
        });
    }

    @Test
    @Owner("ONamozov")
    @Severity(SeverityLevel.NORMAL)
    public void checkSuccessfulNumberTest() {
        step("Проверка ввода корректного номера", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+79991112233");
            $(By.id("ru.alfabank.mobile.android:id/button_container"))
                    .click();
            $(By.id("ru.alfabank.mobile.android:id/toolbar"))
                    .shouldHave(visible);
        });
    }
}
