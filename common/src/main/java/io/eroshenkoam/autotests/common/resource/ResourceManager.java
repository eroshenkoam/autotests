package io.eroshenkoam.autotests.common.resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class ResourceManager {

    private final ObjectMapper mapper;

    private final ClassLoader classLoader;

    @Inject
    public ResourceManager(final ObjectMapper mapper, final ClassLoader classLoader) {
        this.classLoader = classLoader;
        this.mapper = mapper;
    }

    public <T> T readResource(final String name, final Class<T> type) {
        try {
            return mapper.readValue(getResourceStream(name), type);
        } catch (IOException e) {
            throw new ResourceException("Can't read resource " + name + " as " + type, e);
        }
    }

    public <T> T readResource(final String name, final TypeReference<T> ref) {
        try {
            return mapper.readValue(getResourceStream(name), ref);
        } catch (IOException e) {
            throw new ResourceException("Can't read resource " + name + " as " + ref, e);
        }
    }

    public String readResourceAsString(final String name) {
        final InputStream resource = getResourceStream(name);
        try {
            return IOUtils.toString(resource, "UTF-8");
        } catch (IOException e) {
            throw new ResourceException("Can't read resource " + name, e);
        }
    }

    protected InputStream getResourceStream(final String name) {
        return getClassLoader().getResourceAsStream(name);
    }

    protected ClassLoader getClassLoader() {
        return this.classLoader;
    }

}
