package io.eroshenkoam.autotests.web.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.eroshenkoam.autotests.common.guice.CustomScopes;
import io.eroshenkoam.autotests.web.config.WebConfig;
import io.eroshenkoam.autotests.web.webdriver.DefaultWebDriverManager;
import io.eroshenkoam.autotests.web.webdriver.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WebDriverManager.class).toProvider(DefaultWebDriverManager::new).in(CustomScopes.THREAD_LOCAL);
    }

    @Provides
    public WebConfig provideWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

}
