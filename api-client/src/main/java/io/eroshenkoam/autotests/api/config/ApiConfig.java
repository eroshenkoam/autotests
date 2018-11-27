package io.eroshenkoam.autotests.api.config;

import org.aeonbits.owner.Config;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Config.Sources("classpath:testing.properties")
public interface ApiConfig extends Config {

    @Key("api.baseUrl")
    String getBaseUrl();

}
