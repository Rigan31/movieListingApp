package UnitTests;

import Components.User;
import Components.UserRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void addUser() {
        // Given
        UserRepository userRepository = new UserRepository();
        User user = new User("test@example.com");

        // When
        userRepository.addUser(user);
        List<User> users = userRepository.getUsers();

        // Then
        assertTrue(users.contains(user));
    }

    @Test
    void getUsers() {
        // Given
        UserRepository userRepository = new UserRepository();
        User user1 = new User("user1@example.com");
        User user2 = new User("user2@example.com");
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        // When
        List<User> users = userRepository.getUsers();

        // Then
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    void getUserByEmail() {
        // Given
        UserRepository userRepository = new UserRepository();
        User user1 = new User("user1@example.com");
        User user2 = new User("user2@example.com");
        userRepository.addUser(user1);
        userRepository.addUser(user2);

        // When
        User foundUser = userRepository.getUserByEmail("user1@example.com");

        // Then
        assertEquals(user1, foundUser);
    }
}
