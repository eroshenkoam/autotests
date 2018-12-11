package io.eroshenkoam.autotests.common.resource;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class ResourceException extends RuntimeException {

    public ResourceException (final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
