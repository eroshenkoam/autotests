package io.eroshenkoam.autotests.api.step;

import io.eroshenkoam.autotests.api.GithubClient;
import io.eroshenkoam.autotests.api.Repository;

import javax.inject.Inject;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class GithubApiSteps {

    private final GithubClient client;

    @Inject
    public GithubApiSteps(final GithubClient client) {
        this.client = client;
    }


    public String[] getRepositoriesNames(final String owner) {
        return client.listRepos(owner).stream()
                .map(Repository::getName)
                .toArray(String[]::new);
    }

}
