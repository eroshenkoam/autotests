package io.eroshenkoam.autotests.common.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class DefaultWebDriverManager implements WebDriverManager {

    private WebDriver driver;

    @Override
    public void startWebDriver() {

    }

    @Override
    public void stopWebDriver() {

    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

}
