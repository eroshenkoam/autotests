package io.eroshenkoam.autotests.db.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.eroshenkoam.autotests.db.DatabaseClient;
import io.eroshenkoam.autotests.db.config.DatabaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.skife.jdbi.v2.DBI;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class DatabaseModule extends AbstractModule {

    @Override
    protected void configure() {
        //Do nothing
    }

    @Provides
    protected DatabaseConfig provideCapstoneConfig() {
        return ConfigFactory.newInstance().create(DatabaseConfig.class, System.getProperties());
    }

    @Provides
    protected DBI provideDBI(final DatabaseConfig config) {
        return new DBI(config.getUrl(), config.getUsername(), config.getPassword());
    }

    @Provides
    protected DatabaseClient provideDatabaseClient(final DBI dbi) {
        return createDbo(dbi, DatabaseClient.class);
    }

    protected <T> T createDbo(DBI dbi, Class<T> client) {
        return dbi.onDemand(client);
    }

}
