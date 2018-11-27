package io.eroshenkoam.autotests.web.step;

import io.eroshenkoam.autotests.web.config.WebConfig;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class BaseWebSteps {

    @Inject
    private WebConfig config;

    public void openMainPage() {

    }

    public void openRepositoriesList(String owner) {

    }

    public void repositoriesListShouldContains(String... names) {

    }

}
