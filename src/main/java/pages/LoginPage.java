package pages;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends BasePage {

    private static Map<String, String> pageMap;
     static {
        pageMap = new HashMap<>();
        pageMap.put("UserID", "//input[@name='userName']");
        pageMap.put("Password", "//input[@name='password']");
        pageMap.put("Login Button", "//input[@value='Login']");
    }

    public void loginApplication(String userId, String password) {
        driver.findElement(By.xpath(pageMap.get("UserID"))).sendKeys(userId);
        driver.findElement(By.xpath(pageMap.get("Password"))).sendKeys(password);
        driver.findElement(By.xpath(pageMap.get("Login Button"))).click();
    }
}
