package mobile.tests.emulationAndroid;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mobile.tests.TestBase;
import org.junit.jupiter.api.DisplayName;
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
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка тайтла на экране входа")
    void checkTitleOnWelcomeScreenTest() {
        step("Проверка тайтла на экране входа", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
        });
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Проверка, что кнопка зайти задизейблена если поле ввода не заполнено")
    void checkClickableFalseOnEnterButtonTest() {
        step("Вводим в инпут поле +7", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+7");
        });
        step("Проверяем, что кнопка Зайти задизейблена", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("clickable", "false"));
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка, что у кнопки входа текст Зайти")
    void checkShouldHaveButtonEnterTest() {
        step("Проверка, что у кнопки входа текст Зайти", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("text", "Зайти"));
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ввода некорректного РФ телефона")
    public void checkBadHuntWithBadRuNumberTest() {
        step("Вводим некорректный РФ телефон", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+71111111111");
        });
        step("Проверяем текст ошибки на некорректный номер телефона", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_hint"))
                    .shouldHave(text("Некорректный номер телефона"));
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ввода иностранного телефона")
    public void checkBadHuntWithInoNumberTest() {
        step("Вводим некорректный номер телефона", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("12312321321");
        });
        step("Кликаем на кнопку Зайти", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_container"))
                    .click();
        });
        step("Проверяем текст ошибки", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_hint"))
                    .shouldHave(text("Кажется, это иностранный номер. Введите номер российского оператора"));
        });
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка ввода корректного номера")
    public void checkSuccessfulNumberTest() {
        step("Вводим корректный номер телефона", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+79991112233");
        });
        step("Кликаем на кнопку Зайти", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_container"))
                    .click();
        });
        step("Проверяем, что тулбар виден", () -> {
            $(By.id("ru.alfabank.mobile.android:id/toolbar"))
                    .shouldHave(visible);
        });
    }
}
