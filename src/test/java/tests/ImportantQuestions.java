package tests;

import PageObject.MainPage;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;


public class ImportantQuestions {
    private List<String> listOfQuestions = new ArrayList<>(){{
        add("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        add("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        add("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        add("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        add("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        add("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        add("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        add("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }};

    private WebDriver driver;
    @Before
    public void setup(){
        System.out.println("======Установление соединения======");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    // Проверка кликабельности и содержимого
    @Test
    public void importantQuestionsTest(){
        System.out.println("======Тест содержимого вопросов о важном======");
        MainPage mainPage = new MainPage(driver);

        // Проверка каждого вопроса
        System.out.println("Необходимый текст   |   Выводимый текст");
        for (int i = 0; i < mainPage.getListOfQuestions().size(); i++) {
            System.out.println(listOfQuestions.get(i) + "   |   " + mainPage.getImportantQuestions(i));
            try {
                assertEquals(listOfQuestions.get(i), mainPage.getImportantQuestions(i));
            } catch (AssertionError assertionError) {
                System.out.println("При выполнении теста на элементе " + listOfQuestions.get(i) + " появилась ошибка");
                throw new AssertionError(assertionError);
            }
        }
    }

    @After
    public void closeConnect(){
        System.out.println("======Закрытие соединения======");
        driver.quit();
    }
}
