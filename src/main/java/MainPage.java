import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final By bottomOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    private final By topOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //     Открыть страницу
    public void open(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitUntilElementIsClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilElementIsVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void acceptCookie(){
        WebElement acceptButton = waitUntilElementIsClickable(By.id("rcc-confirm-button"));
        acceptButton.click();
    }

    public String getQuestionById(String id){
        WebElement questionElement = waitUntilElementIsVisible(By.id("accordion__heading-"+id));
        return questionElement.getText();
    }
    public void clickOnQuestion(String id){
        WebElement questionButton = waitUntilElementIsClickable(By.id("accordion__heading-"+id));
        questionButton.click();
    }

    public String getAnswerById(String id){
        WebElement answerElement = waitUntilElementIsVisible(By.id("accordion__panel-"+id));
        return answerElement.getText();
    }

    public void clickBottomOrderButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bottomOrderButton)).click();


    }
    public void clickTopOrderButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(topOrderButton)).click();
    }





}
