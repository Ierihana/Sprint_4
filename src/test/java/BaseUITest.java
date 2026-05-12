import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseUITest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @Before
// Запустить браузер
    public void startBrowser(){
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("firefox")){
            startFirefoxBrowser();
        } else if (browser.equals("chrome")){
            startChromeBrowser();
        }
    }

    public void startChromeBrowser(){
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

    public void startFirefoxBrowser(){
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
    }

// Закрыть браузер
    @After
    public void tearDown(){
        driver.quit();
    }
}
