package UnitTests;

import Components.Movie;
import Components.MovieRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {

    @Test
    void addMovie() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        Movie movie = new Movie("Test Movie", null, null, null, 0);

        // When
        movieRepository.addMovie(movie);
        List<Movie> movies = movieRepository.getMovies();

        // Then
        assertTrue(movies.contains(movie));
    }

    @Test
    void getMovies() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        Movie movie1 = new Movie("Movie 1", null, null, null, 0);
        Movie movie2 = new Movie("Movie 2", null, null, null, 0);
        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);

        // When
        List<Movie> movies = movieRepository.getMovies();

        // Then
        assertEquals(2, movies.size());
        assertTrue(movies.contains(movie1));
        assertTrue(movies.contains(movie2));
    }

    @Test
    void searchMovies() {
        // Given
        MovieRepository movieRepository = new MovieRepository();
        List<String> cast1 = Arrays.asList("Actor A", "Actor B", "Actor C");
        List<String> cast2 = Arrays.asList("Actor D", "Actor E", "Actor F");
        List<String> cast3 = Arrays.asList("Actor G", "Actor H", "Actor I");
        Movie movie1 = new Movie("Movie 1", cast1, "Action", null, 0);
        Movie movie2 = new Movie("Movie 2", cast2, "Drama", null, 0);
        Movie movie3 = new Movie("Movie 3", cast3, "Action", null, 0);
        movieRepository.addMovie(movie1);
        movieRepository.addMovie(movie2);
        movieRepository.addMovie(movie3);

        // When
        List<Movie> searchResults1 = movieRepository.searchMovies("Action");
        List<Movie> searchResults2 = movieRepository.searchMovies("Drama");
        List<Movie> searchResults3 = movieRepository.searchMovies("Comedy");

        // Then
        assertEquals(2, searchResults1.size());
        assertTrue(searchResults1.contains(movie1));
        assertTrue(searchResults1.contains(movie3));

        assertEquals(1, searchResults2.size());
        assertTrue(searchResults2.contains(movie2));

        assertTrue(searchResults3.isEmpty());
    }

}
