package mobile.tests.androidBrowserStack;

import com.codeborne.selenide.Condition;
import mobile.tests.TestBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("android_browserstack")
public class AlfaBankStartScreenTest extends TestBase {
    @BeforeAll
    static void setup() {
        System.setProperty("platform", "android");
    }

    @Test
    void checkTitleOnWelcomeScreenTest() {
        step("Проверка тайтла на экране входа", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_view_component_title_view"))
                    .shouldHave(text("Привет! Введите телефон и заходите скорее"));
        });
    }

    @Test
    void checkClickableFalseOnEnterButtonTest() {
        step("Проверка, что кнопка зайти задизейблена если поле ввода не заполнено", () -> {
            $(By.id("ru.alfabank.mobile.android:id/text_field_input"))
                    .sendKeys("+7");
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("clickable", "false"));
        });
    }

    @Test
    void checkShouldHaveButtonEnterTest() {
        step("Проверка, что у кнопки входа текст Зайти", () -> {
            $(By.id("ru.alfabank.mobile.android:id/button_text"))
                    .shouldHave(Condition.attribute("text", "Зайти"));
        });
    }

    @Test
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
    public void checkSuccessfulNumberTest() {
        step("Проверка ввода некорректного иностранного телефона", () -> {
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
