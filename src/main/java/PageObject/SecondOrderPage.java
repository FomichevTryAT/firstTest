package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SecondOrderPage {
    // Поле даты
    private SelenideElement dateField = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input"));

    // Выбор срока
    private SelenideElement chooseTerm = $(byClassName("Dropdown-root")).find(byClassName("Dropdown-arrow"));

    // Выбор цвета
    private SelenideElement colorField = $(byClassName("Order_Checkboxes__3lWSI"));

    // Кнопка заказа
    private SelenideElement doOrder = $(byClassName("Order_Buttons__1xGrp")).$(byText("Заказать"));

    // Модальное окно подтверждение заказа
    private SelenideElement modalWindow = $x(".//div[contains(@class, 'Order_ModalHeader')]");

    // Кнопка "Да" в модальном окне подтверждения заказа
    private SelenideElement yesButtonModalWindow = $(byXpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]"));

    // Текст заказа
    private SelenideElement textAccept = modalWindow.$(".Order_ModalHeader__3FDaJ");

    public void setDateField(String date) {
        dateField.shouldBe(visible).setValue(date);
    }

    public void setTerm(String term){
        chooseTerm.click();
        $(byClassName("Dropdown-menu")).$$(byClassName("Dropdown-option")).findBy(text(term)).click();
    }

    public void setColorField(String color){
        colorField.find(byId(color)).click();
    }

    public void acceptOrder(){
        modalWindow.shouldBe(enabled);
        yesButtonModalWindow.shouldBe(visible).click();
    }
    public void fillFields(String date, String term, String color, String comm){
        setDateField(date);
        setTerm(term);
        setColorField(color);
        doOrder.click();
        acceptOrder();
        System.out.println($(byClassName("Order_Modal__YZ-d3")).$(".Order_ModalHeader__3FDaJ").getText());
    }
}
