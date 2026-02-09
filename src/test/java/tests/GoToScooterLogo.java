package tests;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoToScooterLogo {
    WebDriver driver;

    @Before
    public void setup(){
        System.out.println("======Установление соединения======");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void goToScooter(){
        System.out.println("======Проверка кликабельности логотипа Самокат======");
        MainPage mainPage = new MainPage(driver);
        System.out.println("===Проверка перехода со страницы заказа===");
        mainPage.toOrder();
        assertEquals(mainPage.clickScooterLogo(), "Самокат");
    }

    @After
    public void closeConnect(){
        System.out.println("======Закрытие соединения======");
        driver.quit();

    }

}
