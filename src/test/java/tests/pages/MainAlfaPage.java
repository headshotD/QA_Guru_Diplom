package tests.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Data
public class MainAlfaPage {
    public static MainAlfaPage openPage() {
        open("https://alfabank.ru/");
        return new MainAlfaPage();
    }
    private final SelenideElement news = $("#menu-item-452"),
            contacts = $("#menu-item-203"),
            products = $("#menu-item-1081"),
            awards = $("#menu-item-418");
}
