package tests;


import PageObject.MainPage;
import PageObject.SecondOrderPage;
import PageObject.OrderPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class DoOrder {
    @Test
    public void mainTest() {
        open("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = page(MainPage.class);
        OrderPage orderPage = mainPage.toOrder();
        SecondOrderPage secondOrderPage = orderPage.fillAllFields("Игнатий", "Вентуров", "Комсомольская 3", "Черкизовская", "79993229999");
        secondOrderPage.fillFields("26.06.2025", "сутки", "black", "--");
    }
}
