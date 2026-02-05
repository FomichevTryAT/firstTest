package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    // Кнопка "Заказать"
    private SelenideElement buttonOrder = $(byClassName("Button_Button__ra12g"));

    // Кнопка "Статус заказа"
    private SelenideElement statusButton = $(byClassName("Header_Link__1TAG7"));

    // Кнопка "Заказать" в середине
    private SelenideElement middleButtonOrder = $(byClassName("Home_FinishButton__1_cWm")).$("Button_Button__ra12g");

    // "Вопросы о важном"
    private SelenideElement tasksOfImportant = $(byClassName("accordion__item"));

    // Кнопка куки
    private SelenideElement cookieClose = $(byClassName("App_CookieButton__3cvqF"));

    // Вопросы о важном - список
    private ElementsCollection importantQuestionList = $$(byClassName("accordion"));

    public void closeCookies(){
        cookieClose.click();
    }

    // Переход к заказу
    public OrderPage toOrder(){
        closeCookies();
        buttonOrder.click();
        return page(OrderPage.class);
    }

    public void getImportantQuestion(Integer numberOfList){
        System.out.println(importantQuestionList.get(numberOfList).$(byId("accordion__heading")).getText());
    }
}
