package io.eroshenkoam.autotests.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.eroshenkoam.autotests.api.GithubClient;
import io.eroshenkoam.autotests.api.config.ApiConfig;
import io.eroshenkoam.autotests.api.retrofit.DefaultCallAdapterFactory;
import io.eroshenkoam.autotests.api.retrofit.DefaultCookieJar;
import okhttp3.OkHttpClient;
import org.aeonbits.owner.ConfigFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class ApiModule extends AbstractModule {

    @Provides
    protected ApiConfig provideApiConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }

    @Provides
    protected GithubClient providesGithubClient(final ApiConfig config) {
        final OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new DefaultCookieJar())
                .build();

        final Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(new DefaultCallAdapterFactory<>())
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(config.getBaseUrl())
                .client(client)
                .build();
        return retrofit.create(GithubClient.class);
    }

}
