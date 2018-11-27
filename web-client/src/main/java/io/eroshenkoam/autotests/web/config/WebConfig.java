package io.eroshenkoam.autotests.web.config;

import org.aeonbits.owner.Config;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */

@Config.Sources("classpath:testing.properties")
public interface WebConfig extends Config {

    @Key("web.baseUrl")
    String getBaseUrl();

}
