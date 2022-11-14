import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class YandexPageFactory {

    protected WebDriver driver;

    public YandexPageFactory(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, xpath = "//button[@id='catalogPopupButton']")
    protected WebElement catalogButton;

    @FindBy(how = How.XPATH, xpath = "//a//span[contains(text(), 'Ноутбуки и компьютеры')]")
    protected WebElement computerAndNotebookItem;

    @FindBy(how = How.XPATH, xpath = "//li//a[contains(text(),'Ноутбуки')]")
    protected WebElement notebook;

    @FindBy(how = How.XPATH, xpath = "//div[@data-filter-id='glprice']//span[@data-auto='filter-range-min']//input[@type='text']")
    protected WebElement minPrice;

    @FindBy(how = How.XPATH, xpath = "//div[@data-filter-id='glprice']//span[@data-auto='filter-range-max']//input[@type='text']")
    protected WebElement maxPrice;

    @FindBy(how = How.XPATH, xpath = "//h4[contains(text(), 'Производитель')]//ancestor::legend//following-sibling::div//span[contains(text(), 'Lenovo')]")
    protected WebElement itemLenovo;

    @FindBy(how = How.XPATH, xpath = "//h4[contains(text(), 'Производитель')]//ancestor::legend//following-sibling::div//span[contains(text(), 'HP')]")
    protected WebElement itemHP;

    @FindBy(how = How.XPATH, xpath = "//div[@data-index]//h3")
    protected List<WebElement> listOfData;

    @FindBy(how = How.XPATH, xpath = "//input[@id='header-search']")
    protected WebElement searchField;

    @FindBy(how = How.XPATH, xpath = "//button[@data-r='search-button']")
    protected WebElement searchButton;


    public List<WebElement> getListOfData() {
        return listOfData;
    }

    public WebElement getCatalogButton() {
        return catalogButton;
    }

    public WebElement getComputerAndNotebookItem() {
        return computerAndNotebookItem;
    }

    public WebElement getItemLenovo() {
        return itemLenovo;
    }

    public WebElement getItemHP() {
        return itemHP;
    }

    public void getCatalog() {
        catalogButton.click();
    }

    public void chooseElement() {
        computerAndNotebookItem.click();
    }

    public WebElement getNotebook() {
        return notebook;
    }

    public void chooseNotebook() {
        getNotebook().click();
    }

    public void enterPriceRange(int first, int second) {
        minPrice.click();
        minPrice.sendKeys(String.valueOf(first));
        maxPrice.click();
        maxPrice.sendKeys(String.valueOf(second));
    }

    public void chooseProducer() throws InterruptedException {
        getItemLenovo().click();
        Thread.sleep(5000);
        getItemHP().click();
    }



//    public void chooseFirstItem() {
//        getListOfData().forEach(x-> System.out.println(x.getText()));
//    }

    public String chooseFirstItem() {
        return listOfData.get(0).getText();
    }

    public void foundFirstItem() {
        searchField.click();
        searchField.sendKeys(chooseFirstItem());
        searchButton.click();
    }
}
