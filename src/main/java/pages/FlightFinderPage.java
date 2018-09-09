package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class FlightFinderPage extends BasePage {

    private static Map<String, String> pageMap;
    private WebDriver driver;

    public FlightFinderPage(WebDriver driver) {
        this.driver = driver;
    }

    static {
        pageMap = new HashMap<>();
        pageMap.put("Flight type", "//input[@name='tripType']");
        pageMap.put("Passengers", "//select[@name='passCount']");
        pageMap.put("Departing From", "//select[@name='fromPort']");
        pageMap.put("On_Month", "//select[@name='fromMonth']");
        pageMap.put("On_Date", "//select[@name='fromDay']");
        pageMap.put("Arriving In", "//select[@name='toPort']");
        pageMap.put("Returning_Month", "//select[@name='toMonth']");
        pageMap.put("Returning_Date", "//select[@name='toDay']");
        pageMap.put("Service Class type", "//input[@name='servClass']");
        pageMap.put("Airline", "//select[@name='airline']");
        pageMap.put("Continue Button", "//input[@name='findFlights']");
    }

    public void fillFlightDetails(String fieldName, String value) {
        driver.findElement(By.xpath(fieldName)).sendKeys(value);
    }
}
