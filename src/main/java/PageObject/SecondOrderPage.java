package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SecondOrderPage {
    // driver
    private WebDriver driver;

    // Поле даты
    private By dateField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/input");

    // Выбор срока
    private By chooseTerm =By.className("Dropdown-arrow");

    // Выбор цвета
    private By colorField = By.className("Order_Checkboxes__3lWSI");

    // Кнопка заказа
    private By doOrder = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    // Модальное окно подтверждение заказа
    private By modalWindow = By.xpath(".//div[contains(@class, 'Order_ModalHeader')]");

    // Кнопка "Да" в модальном окне подтверждения заказа
    private By yesButtonModalWindow = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    // Текст заказа
    private By acceptButton = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    public SecondOrderPage (WebDriver driver){
        this.driver = driver;
    }
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys("08.02.2026");
    }

    public void setTerm(String term){
        driver.findElement(chooseTerm).click();
        driver.findElement(By.className("Dropdown-menu"));
        driver.findElement(By.xpath(".//*[@role='option' and text()='" + term + "']")).click();
    }

    public void setColorField(String color){
        driver.findElement(colorField).findElement(By.xpath(".//input[@id='" + color +"']")).click();
    }

    public void acceptOrder(){
        driver.findElement(doOrder).click();
    }
    public void fillFields(String date, String term, String color, String comm){
        setDateField(date);
        setTerm(term);
        setColorField(color);
        acceptOrder();
        ((JavascriptExecutor)driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('click', {bubbles: true, cancelable: true}));", driver.findElement(acceptButton));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
