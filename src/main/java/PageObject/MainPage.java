package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.assertEquals;


public class MainPage {
    // driver
    private WebDriver driver;

    // Кнопка "Заказать"
    private By buttonOrder = By.className("Button_Button__ra12g");

    // Кнопка "Статус заказа"
    private By statusButton = By.className("Header_Link__1TAG7");

    // Поле ввода номера заказа
    private By fieldOfNumber = By.xpath(".//input[@placeholder='Введите номер заказа']");

    // Кнопка "Go"
    private By goButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    // Кнопка "Заказать" в середине
    private By middleButtonOrder = By.className("Home_FinishButton__1_cWm");

    // "Вопросы о важном"
    private By tasksOfImportant = By.className("accordion");

    // Кнопка куки
    private By cookieClose = By.className("App_CookieButton__3cvqF");

    // Логотип яндекс
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");

    // Логотип Самокат
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");

    // Локатор для проверки перехода на главную
    private By mainPageLocator = By.className("Home_Header__iJKdX");

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    // Проверка кликабельности кнопки Яндекс
    public void clickYandexLogo(){
        driver.findElement(yandexLogo).click();
    }

    // Проверка кликабельности кнопки Самокат
    public String clickScooterLogo(){
        driver.findElement(scooterLogo).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(mainPageLocator));
        return driver.findElement(mainPageLocator).getText();
    }

    public void closeCookies(){
        driver.findElement(cookieClose).click();
    }

    public void clickButtonOrder(){
        driver.findElement(buttonOrder).click();
    }

    // Переход к заказу
    public OrderPage toOrder(){
        closeCookies();
        clickButtonOrder();
        return new OrderPage(driver);
    }

    // Получение количества вопросов
    public List<WebElement> getListOfQuestions(){
        List<WebElement> listOfQuestions =  driver.findElement(tasksOfImportant).findElements(By.className("accordion__item"));
        return listOfQuestions;
    }

    public String getImportantQuestions(Integer numberOfQuestion){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", getListOfQuestions().get(numberOfQuestion));
        WebElement question = getListOfQuestions().get(numberOfQuestion);
        question.click();
        question.findElement(By.id("accordion__panel-" + numberOfQuestion));
        return question.findElement(By.tagName("p")).getText();
    }

    // Проверка статуса заказа
    public void checkStatus(String numberOfOrder){
        driver.findElement(statusButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(fieldOfNumber));
        driver.findElement(fieldOfNumber).sendKeys(numberOfOrder);
        driver.findElement(goButton).click();
    }
}
