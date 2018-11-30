package io.eroshenkoam.autotests.web.step;

import io.eroshenkoam.autotests.web.webdriver.WebDriverManager;
import io.eroshenkoam.autotests.web.config.WebConfig;
import io.eroshenkoam.autotests.web.page.GithubMainPage;
import io.qameta.atlas.Atlas;
import io.qameta.atlas.WebDriverConfiguration;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class BaseWebSteps {

    private final WebConfig webConfig;

    private final WebDriverManager driverManager;

    @Inject
    public BaseWebSteps(final WebConfig webConfig,
                        final WebDriverManager driverManager) {
        this.webConfig = webConfig;
        this.driverManager = driverManager;
    }

    public void openMainPage() {
        onMainPage().open(webConfig.getBaseUrl());
    }

    public void openRepositoriesList(final String owner) {
        //open repositories list
    }

    public void repositoriesListShouldContains(final String... names) {
        //check repositories list
    }

    private GithubMainPage onMainPage() {
        return onPage(GithubMainPage.class);
    }

    private <T> T onPage(Class<T> page) {
        return getAtlas().create(driverManager.getWebDriver(), page);
    }

    private Atlas getAtlas() {
        return new Atlas(new WebDriverConfiguration(driverManager.getWebDriver()));
    }

}
