package UnitTests;

import Components.Movie;
import Components.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void addToFavorites() {
        // Given
        Movie movie = new Movie("Movie Title", null, null, null, 0);
        User user = new User("test@example.com");

        // When
        user.addToFavorites(movie);

        // Then
        assertTrue(user.getFavorites().contains(movie));
    }

    @Test
    void removeFromFavorites() {
        // Given
        Movie movie = new Movie("Movie Title", null, null, null, 0);
        User user = new User("test@example.com");
        user.addToFavorites(movie);

        // When
        user.removeFromFavorites(movie);

        // Then
        assertFalse(user.getFavorites().contains(movie));
    }

    @Test
    void getFavorites() {
        // Given
        Movie movie1 = new Movie("Movie 1", null, null, null, 0);
        Movie movie2 = new Movie("Movie 2", null, null, null, 0);
        User user = new User("test@example.com");
        user.addToFavorites(movie1);
        user.addToFavorites(movie2);

        // When
        List<Movie> favorites = user.getFavorites();

        // Then
        assertEquals(2, favorites.size());
        assertTrue(favorites.contains(movie1));
        assertTrue(favorites.contains(movie2));
    }

    @Test
    void getEmail() {
        // Given
        String email = "test@example.com";
        User user = new User(email);

        // When
        String actualEmail = user.getEmail();

        // Then
        assertEquals(email, actualEmail);
    }

}
