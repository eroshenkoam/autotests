package io.eroshenkoam.autotests.common.guice;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class ThreadLocalScope implements Scope {

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) {
        return () -> {
            ThreadLocalCache cache = ThreadLocalCache.getInstance();
            T value = cache.get(key);
            if (value == null) {
                value = creator.get();
                cache.add(key, value);
            }
            return value;
        };
    }

    private static final class ThreadLocalCache {

        private Map<Key<?>, Object> map = new HashMap<>();
        private static final ThreadLocal<ThreadLocalCache> THREAD_LOCAL =
                ThreadLocal.withInitial(ThreadLocalCache::new);

        @SuppressWarnings("unchecked")
        <T> T get(Key<T> key) {
            return (T) map.get(key);
        }

        <T> void add(Key<T> key, T value) {
            map.put(key, value);
        }

        static ThreadLocalCache getInstance() {
            return THREAD_LOCAL.get();
        }
    }

}