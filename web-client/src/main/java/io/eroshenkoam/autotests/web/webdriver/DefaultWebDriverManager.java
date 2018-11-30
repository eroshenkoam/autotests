package io.eroshenkoam.autotests.web.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class DefaultWebDriverManager implements WebDriverManager {

    private WebDriver driver;

    @Override
    public void startWebDriver() {
        driver = new ChromeDriver();
    }

    @Override
    public void stopWebDriver() {
        driver.quit();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

}
