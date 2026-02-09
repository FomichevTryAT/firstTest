package tests;

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckOrder {
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
        mainPage.checkStatus("123");
        try {
            driver.findElement(By.className("Track_Content__St6Kn"));
            System.out.println("Заказ существует");
        } catch (NoSuchElementException noSuchElementException){
            System.out.println("Заказа не существует");
        }
    }

    @After
    public void closeConnect(){
        System.out.println("======Закрытие соединения======");
        driver.quit();
    }

}
