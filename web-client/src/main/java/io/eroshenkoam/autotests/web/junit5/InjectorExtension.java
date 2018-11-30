package io.eroshenkoam.autotests.web.junit5;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.eroshenkoam.autotests.web.module.WebModule;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public interface InjectorExtension extends TestInstancePostProcessor {

    @Override
    default void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        Injector injector = Guice.createInjector(new WebModule());
        injector.injectMembers(this);
    }

}

