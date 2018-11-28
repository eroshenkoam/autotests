package io.eroshenkoam.autotests.db.config;

import org.aeonbits.owner.Config;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Config.Sources({"classpath:testing.properties"})
public interface DatabaseConfig extends Config {

    String getUrl();

    String getUsername();

    String getPassword();

}
