package io.eroshenkoam.autotests.web.step;

import io.eroshenkoam.autotests.web.config.WebConfig;
import io.eroshenkoam.autotests.web.webdriver.WebDriverManager;
import io.qameta.atlas.Atlas;
import io.qameta.atlas.WebDriverConfiguration;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class BaseSteps {

    private final WebConfig webConfig;

    private final WebDriverManager driverManager;

    @Inject
    public BaseSteps(final WebConfig webConfig,
                     final WebDriverManager driverManager) {
        this.webConfig = webConfig;
        this.driverManager = driverManager;
    }

    protected <T> T onPage(Class<T> page) {
        return getAtlas().create(driverManager.getWebDriver(), page);
    }

    protected Atlas getAtlas() {
        return new Atlas(new WebDriverConfiguration(driverManager.getWebDriver()));
    }

    protected WebConfig getWebConfig() {
        return webConfig;
    }
}
