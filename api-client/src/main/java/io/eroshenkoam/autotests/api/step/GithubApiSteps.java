package io.eroshenkoam.autotests.api.step;

import io.eroshenkoam.autotests.api.GithubClient;
import io.eroshenkoam.autotests.api.Repository;
import io.eroshenkoam.autotests.api.config.ApiConfig;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class GithubApiSteps {

    private final ApiConfig config;

    private final GithubClient client;

    @Inject
    public GithubApiSteps(final ApiConfig config, final GithubClient client) {
        this.config = config;
        this.client = client;
    }


    public String[] getRepositoriesNames(String owner) {
        return client.listRepos(owner).stream()
                .map(Repository::getName)
                .toArray(String[]::new);
    }

}
