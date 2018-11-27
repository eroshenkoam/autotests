package io.eroshenkoam.autotests.common.webdriver;

import org.openqa.selenium.WebDriver;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public interface WebDriverManager {

    void startWebDriver();

    void stopWebDriver();

    WebDriver getWebDriver();

}
