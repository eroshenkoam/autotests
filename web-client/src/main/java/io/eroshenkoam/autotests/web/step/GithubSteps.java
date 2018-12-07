package io.eroshenkoam.autotests.web.step;

import io.eroshenkoam.autotests.web.page.MainPage;
import io.eroshenkoam.autotests.web.webdriver.WebDriverManager;
import io.eroshenkoam.autotests.web.config.WebConfig;
import io.eroshenkoam.autotests.web.page.UserPage;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class GithubSteps extends BaseSteps{


    public GithubSteps(WebConfig webConfig, WebDriverManager driverManager) {
        super(webConfig, driverManager);
    }

    public void openUserPage(final String owner) {
        onMainPage().open(String.format("%s/%s", getWebConfig().getBaseUrl(), owner));
    }

    public UserPage onUserPage() {
        return onPage(UserPage.class);
    }

    public MainPage onMainPage() {
        return onPage(MainPage.class);
    }
}
