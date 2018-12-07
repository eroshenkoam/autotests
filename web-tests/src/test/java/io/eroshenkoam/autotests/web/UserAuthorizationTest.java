package io.eroshenkoam.autotests.web;

import io.eroshenkoam.autotests.api.module.ApiModule;
import io.eroshenkoam.autotests.web.junit5.WebDriverExtension;
import io.eroshenkoam.autotests.web.module.WebModule;
import io.eroshenkoam.autotests.web.step.GithubSteps;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.inject.Inject;

import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@ExtendWith({
        GuiceExtension.class,
        WebDriverExtension.class
})
@IncludeModule({
        ApiModule.class,
        WebModule.class
})
public class UserAuthorizationTest {

    @Inject
    private GithubSteps webSteps;

    @Test
    public void usernameShouldBeVisibleAfterSuccessfulLogin() {
        webSteps.openUserPage("eroshenkoam");
        webSteps.onUserPage().userCard()
                .should(displayed());
        webSteps.onUserPage().userCard().nickname()
                .should(hasText("eroshenkoam"));
    }

}
