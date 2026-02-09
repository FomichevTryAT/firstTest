package tests;


import PageObject.MainPage;
import PageObject.OrderPage;
import PageObject.SecondOrderPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoOrder {
    private WebDriver driver;
    @Before
    public void setup(){
        System.out.println("======Установление соединения======");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void mainTest() {
        System.out.println("======Тест заказа самоката запущен ======");

        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.toOrder();
        orderPage.fillAllFields("Игнатий", "Вентуров", "Комсомольская 3", "Черкизовская", "79993229999");
        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillFields("26.06.2025", "сутки", "black", "--");
    }
    }

