import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexStartPage {

    protected WebDriver chromeDriver;
    protected WebElement catalogButton;
    protected WebElement itemComputers;

    public YandexStartPage(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        this.chromeDriver.get("https://market.yandex.ru/");
        this.catalogButton = chromeDriver.findElement(By.xpath("//button[@id='catalogPopupButton']"));
    }

    public void chooseDirectory(String item) {
        catalogButton.click();
        WebElement element = chromeDriver.findElement(By.xpath("//a//span[contains(text(), \"" + item + "\")]"));
        element.click();
    }
}
