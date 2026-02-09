package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class OrderPage {
    // driver
    private WebDriver driver;

    // Поле Имя
    private By nameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");

    // Поле Фамилия
    private By surnameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");

    // Поле Адрес
    private By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");

    // Поле Метро
    private By metroField = By.className("select-search__value");

    // Поле номера телефона
    private By numberOfPhoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");

    // Кнопка Далее
    private By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public OrderPage (WebDriver driver){
        this.driver = driver;
    }
    public void setNameField (String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSurnameField (String surname){
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void setAddressField (String address){
        driver.findElement(addressField).sendKeys(address);
    }

    public void setNumberOfPhoneField(String number){
        driver.findElement(numberOfPhoneField).sendKeys(number);
    }

    private void setMetroField(String station){
        driver.findElement(metroField).click();
        driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='" + station + "']/ancestor::li")).click();
    }

    private void nextButtonClick(){
        driver.findElement(nextButton).click();
    }
    public OrderPage fillAllFields(String name, String surname, String address, String metro, String numberOfPhone){
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setMetroField(metro);
        setNumberOfPhoneField(numberOfPhone);
        nextButtonClick();
        return new OrderPage(driver);
    }
}
