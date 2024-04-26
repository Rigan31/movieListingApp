package UnitTests;

import Components.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieListingAppTest {

    @Test
    void addMovie() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        Movie movie = new Movie("Test Movie", null, null, null, 0);

        // When
        movieListingApp.addMovie(movie);
        List<Movie> movies = movieRepository.getMovies();

        // Then
        assertTrue(movies.contains(movie));
    }

    @Test
    void searchMovies() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        List<String> cast1 = Arrays.asList("Actor A", "Actor B", "Actor C");
        List<String> cast2 = Arrays.asList("Actor D", "Actor E", "Actor F");
        Movie movie1 = new Movie("Movie 1", cast1, "Action", null, 0);
        Movie movie2 = new Movie("Movie 2", cast2, "Drama", null, 0);
        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);

        // When
        List<Movie> searchResults1 = movieListingApp.searchMovies("Action");
        List<Movie> searchResults2 = movieListingApp.searchMovies("Drama");
        List<Movie> searchResults3 = movieListingApp.searchMovies("Comedy");

        // Then
        assertEquals(1, searchResults1.size());
        assertTrue(searchResults1.contains(movie1));

        assertEquals(1, searchResults2.size());
        assertTrue(searchResults2.contains(movie2));

        assertTrue(searchResults3.isEmpty());
    }


    @Test
    void addUser() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);

        // When
        movieListingApp.addUser("test@example.com");
        List<User> users = userRepository.getUsers();

        // Then
        assertEquals(1, users.size());
        assertEquals("test@example.com", users.get(0).getEmail());
    }

    @Test
    void getUser() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        User user = new User("test@example.com");
        userRepository.addUser(user);

        // When
        User retrievedUser = movieListingApp.getUser("test@example.com");

        // Then
        assertNotNull(retrievedUser);
        assertEquals(user.getEmail(), retrievedUser.getEmail());
    }

    @Test
    void addMovieToFavorites() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        User user = new User("test@example.com");
        userRepository.addUser(user);
        Movie movie = new Movie("Test Movie", null, null, null, 0);
        movieRepository.addMovie(movie);

        // When
        movieListingApp.addMovieToFavorites(user, movie);

        // Then
        assertTrue(user.getFavorites().contains(movie));
    }

    @Test
    void removeMovieFromFavorites() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        User user = new User("test@example.com");
        userRepository.addUser(user);
        Movie movie = new Movie("Test Movie", null, null, null, 0);
        user.addToFavorites(movie);

        // When
        movieListingApp.removeMovieFromFavorites(user, movie);

        // Then
        assertFalse(user.getFavorites().contains(movie));
    }

    @Test
    void getFavoriteMovies() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        UserRepository userRepository = new UserRepository();
        MovieListingApp movieListingApp = new MovieListingApp(movieRepository, userRepository);
        User user = new User("test@example.com");
        userRepository.addUser(user);
        Movie movie1 = new Movie("Movie 1", null, null, null, 0);
        Movie movie2 = new Movie("Movie 2", null, null, null, 0);
        user.addToFavorites(movie1);
        user.addToFavorites(movie2);

        // When
        List<Movie> favoriteMovies = movieListingApp.getFavoriteMovies(user);

        // Then
        assertEquals(2, favoriteMovies.size());
        assertTrue(favoriteMovies.contains(movie1));
        assertTrue(favoriteMovies.contains(movie2));
    }
}
