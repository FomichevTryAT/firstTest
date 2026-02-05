package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderPage {
    // Поле Имя
    private SelenideElement nameField = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input"));

    // Поле Фамилия
    private SelenideElement surnameField = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input"));

    // Поле Адрес
    private SelenideElement addressField = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input"));

    // Поле Метро
    private SelenideElement metroField = $(byClassName("select-search"));

    // Поле номера телефона
    private SelenideElement numberOfPhoneField = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input"));

    // Кнопка Далее
    private SelenideElement nextButton = $(byXpath("//*[@id=\"root\"]/div/div[2]/div[3]/button"));

    public void setNameField (String name){
        nameField.setValue(name);
    }

    public void setSurnameField (String surname){
        surnameField.setValue(surname);
    }

    public void setAddressField (String address){
        addressField.setValue(address);
    }

    public void setNumberOfPhoneField(String number){
        numberOfPhoneField.setValue(number);
    }

    private void setMetroField(String station){
        metroField.click();
        $$(byClassName("select-search__row")).findBy(text(station)).click();
    }

    public SecondOrderPage fillAllFields(String name, String surname, String address, String metro, String numberOfPhone){
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setMetroField(metro);
        setNumberOfPhoneField(numberOfPhone);
        nextButton.click();
        return new SecondOrderPage();
    }
}
