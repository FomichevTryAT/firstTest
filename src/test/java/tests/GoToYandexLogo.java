package tests;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoToYandexLogo {
    WebDriver driver;

    @Before
    public void setup(){
        System.out.println("======Установление соединения======");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void goToYandex(){
        System.out.println("======Проверка кликабельности логотипа Яндекс======");
        MainPage mainPage = new MainPage(driver);
        System.out.println("===Проверка перехода с главной страницы===");
        mainPage.clickYandexLogo();
        Object[] listOfHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) listOfHandles[1]);
        assertEquals(driver.getTitle(), "Дзен — главная новостная информационная платформа, которая помогает миллионам людей узнавать, что происходит в мире.");
    }

    @After
    public void closeConnect(){
        System.out.println("======Закрытие соединения======");
        driver.quit();

    }

}
