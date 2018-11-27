package io.eroshenkoam.autotests.common.junit5;

import org.apiguardian.api.API;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.apiguardian.api.API.Status.STABLE;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
@Tag("regress")
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Regress {
}
