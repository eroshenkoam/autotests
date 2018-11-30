package io.eroshenkoam.autotests.common.guice;

import com.google.inject.Scope;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public final class CustomScopes {

    public static final Scope THREAD_LOCAL = new ThreadLocalScope();

    private CustomScopes() {
    }

}
