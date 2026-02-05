package tests;

import PageObject.MainPage;
import PageObject.SecondOrderPage;
import PageObject.OrderPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ImportantQuestions {
    @Test
    public void importantQuestionsTest(){
        open("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage();
        mainPage.getImportantQuestion(0);
    }
}
