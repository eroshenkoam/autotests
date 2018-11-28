package io.eroshenkoam.autotests.common.junit5;

import io.eroshenkoam.autotests.common.webdriver.DefaultWebDriverManager;
import io.eroshenkoam.autotests.common.webdriver.WebDriverManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebDriverExtension implements BeforeEachCallback, AfterEachCallback {

    private final WebDriverManager manager = new DefaultWebDriverManager();

    @Override
    public void beforeEach(final ExtensionContext context) {
        manager.startWebDriver();
    }

    @Override
    public void afterEach(final ExtensionContext context) {
        manager.stopWebDriver();
    }

}
