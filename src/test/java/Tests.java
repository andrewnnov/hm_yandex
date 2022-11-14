import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests extends BaseTest {

    @Test
    public void foundItemOnYaMarketPageObject() {
        YandexStartPage yandexStartPage = new YandexStartPage(driver);
        yandexStartPage.chooseDirectory("Ноутбуки и компьютеры");
    }


    @Test
    public void foundItemOnYandexMarketPageFactory() throws InterruptedException {
        driver.get("https://market.yandex.ru/");
        Thread.sleep(15000);

        YandexPageFactory yandexPageFactory = PageFactory.initElements(driver, YandexPageFactory.class);
        yandexPageFactory.getCatalog();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(yandexPageFactory.computerAndNotebookItem));

        yandexPageFactory.chooseElement();
        Thread.sleep(10000);
        yandexPageFactory.chooseNotebook();
        Thread.sleep(10000);
        yandexPageFactory.enterPriceRange(10000, 90000);
        Thread.sleep(10000);
        yandexPageFactory.chooseProducer();
        Thread.sleep(10000);
        String first = yandexPageFactory.chooseFirstItem();
        System.out.println(first);
        yandexPageFactory.foundFirstItem();
        Thread.sleep(10000);
        String second = yandexPageFactory.chooseFirstItem();
        System.out.println(second);

        Assertions.assertTrue(second.contains(first), "Значение не совпадает");
    }
}
