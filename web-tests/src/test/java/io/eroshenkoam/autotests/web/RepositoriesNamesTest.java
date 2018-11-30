package io.eroshenkoam.autotests.web;

import io.eroshenkoam.autotests.api.module.ApiModule;
import io.eroshenkoam.autotests.web.junit5.WebDriverExtension;
import io.eroshenkoam.autotests.web.module.WebModule;
import io.eroshenkoam.autotests.web.step.BaseWebSteps;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@ExtendWith({GuiceExtension.class, WebDriverExtension.class})
@IncludeModule({ApiModule.class, WebModule.class})
public class RepositoriesNamesTest {

    @Inject
    private BaseWebSteps webSteps;

    @Test
    public void repositoriesListShouldContainsRepositoriesFromApi() {

        webSteps.openMainPage();

    }

}
