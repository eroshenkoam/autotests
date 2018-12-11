package io.eroshenkoam.autotests.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.eroshenkoam.autotests.common.resource.ResourceManager;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */
public class ResourceManagerTest {

    private final ResourceManager resources =
            new ResourceManager(new ObjectMapper(), ResourceManagerTest.class.getClassLoader());

    @Test
    public void showSingleObjectUseCase() {
        final List<User> users  = resources.readResource("users.json", new TypeReference<List<User>>(){});
        assertEquals(users.size(), 1);
    }

    @Test
    public void showCollectionUseCase() {
        final User user = resources.readResource("user.json", User.class);
        assertEquals(user.getName(), "Artem Eroshenko");
    }


    @Data
    public static class User {

        private String name;
        private String email;

    }

}
