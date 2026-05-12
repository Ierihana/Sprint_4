import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage {
    private final WebDriver driver;
    private final By orderPageHeader = By.className("Order_Header__BZXOb");
    private final By clientName = By.xpath(".//input[@placeholder='* Имя']");
    private final By clientSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By clientAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By clientMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By clientPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By buttonNext = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");
    private final By metroSelector = By.className("select-search__select");
    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By leaseField = By.className("Dropdown-control");
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By yesButton = By.xpath(".//button[text()='Да']");
    private final By orderNumberHeader = By.xpath(".//div[text()='Заказ оформлен']");
    private final By headerAboutLease = By.xpath(".//div[text()='Про аренду']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isOpened(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement orderHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(orderPageHeader));
        return orderHeader.isDisplayed();
    }

    public void fillDeliveryFields(
            String name,String surname, String address, String metro, String phone){
        setClientName(name);
        setClientSurname(surname);
        setAddress(address);
        setMetro(metro);
        setClientPhone(phone);

    }
    public void fillLeaseFields(
            String date, String lease, String scooterColor){
        setDate(date);
        setLease(lease);
        scooterColorSelectionById(scooterColor);
        clickOrderButton();

    }
    public void setClientName(String name){
        driver.findElement(clientName).sendKeys(name);
    }

    public void setClientSurname(String surname){
        driver.findElement(clientSurname).sendKeys(surname);
    }

    public void setAddress(String address){
        driver.findElement(clientAddress).sendKeys(address);
    }

    public void setMetro(String metro) {
        driver.findElement(clientMetro).sendKeys(metro);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(metroSelector));
        driver.findElement(By.xpath(".//li[@class='select-search__row']/button")).click();
    }

    public void setClientPhone(String phone){
        driver.findElement(clientPhone).sendKeys(phone);
    }

    public void clickNextPageButton(){
        driver.findElement(buttonNext).click();

    }

    public void setDate (String date){
        driver.findElement(dateField).sendKeys(date);
    }

    public void setLease (String lease){
        driver.findElement(headerAboutLease).click();
        driver.findElement(leaseField).click();
        driver.findElement(By.xpath(".//div[text()= '"+ lease + "']")).click();

    }

    public void scooterColorSelectionById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickOrderButton(){
        driver.findElement(orderButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public boolean checkingTheOrder (){
        return driver.findElement(orderNumberHeader).isDisplayed();
    }

}
