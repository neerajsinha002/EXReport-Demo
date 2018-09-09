package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import utility.ApplicationProperties;
import utility.TestUtil;
import utility.WebEventListener;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;


    public static void driverInitialization() {
        String browserName = ApplicationProperties.get("browser");
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\MyWork\\EXReport-Demo\\src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }


        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(ApplicationProperties.get("application.url"));
    }
}
