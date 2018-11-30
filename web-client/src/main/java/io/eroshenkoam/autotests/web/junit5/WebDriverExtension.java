package io.eroshenkoam.autotests.web.junit5;

import io.eroshenkoam.autotests.web.webdriver.WebDriverManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebDriverExtension implements BeforeEachCallback, AfterEachCallback, InjectorExtension {

    @Inject
    private WebDriverManager manager;

    @Override
    public void beforeEach(final ExtensionContext context) {
        manager.startWebDriver();
    }

    @Override
    public void afterEach(final ExtensionContext context) {
        manager.stopWebDriver();
    }

}
