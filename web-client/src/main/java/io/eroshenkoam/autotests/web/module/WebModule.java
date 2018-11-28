package io.eroshenkoam.autotests.web.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.eroshenkoam.autotests.web.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class WebModule extends AbstractModule {

    @Provides
    public WebConfig provideWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

}
