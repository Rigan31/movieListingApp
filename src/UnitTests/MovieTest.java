package UnitTests;

import Components.Movie;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    @Test
    void getTitle() {
        // Given
        String title = "Movie Title";
        Movie movie = new Movie(title, null, null, null, 0);

        // When
        String actualTitle = movie.getTitle();

        // Then
        assertEquals(title, actualTitle);
    }

    @Test
    void setTitle() {
        // Given
        Movie movie = new Movie(null, null, null, null, 0);
        String newTitle = "New Movie Title";

        // When
        movie.setTitle(newTitle);
        String actualTitle = movie.getTitle();

        // Then
        assertEquals(newTitle, actualTitle);
    }

    @Test
    void getCast() {
        // Given
        List<String> cast = Arrays.asList("Actor 1", "Actor 2");
        Movie movie = new Movie(null, cast, null, null, 0);

        // When
        List<String> actualCast = movie.getCast();

        // Then
        assertEquals(cast, actualCast);
    }

    @Test
    void setCast() {
        // Given
        Movie movie = new Movie(null, null, null, null, 0);
        List<String> newCast = Arrays.asList("New Actor 1", "New Actor 2");

        // When
        movie.setCast(newCast);
        List<String> actualCast = movie.getCast();

        // Then
        assertEquals(newCast, actualCast);
    }

    @Test
    void getCategory() {
        // Given
        String category = "Action";
        Movie movie = new Movie(null, null, category, null, 0);

        // When
        String actualCategory = movie.getCategory();

        // Then
        assertEquals(category, actualCategory);
    }

    @Test
    void setCategory() {
        // Given
        Movie movie = new Movie(null, null, null, null, 0);
        String newCategory = "Drama";

        // When
        movie.setCategory(newCategory);
        String actualCategory = movie.getCategory();

        // Then
        assertEquals(newCategory, actualCategory);
    }

    @Test
    void getReleaseDate() {
        // Given
        LocalDate releaseDate = LocalDate.of(2022, 4, 28);
        Movie movie = new Movie(null, null, null, releaseDate, 0);

        // When
        LocalDate actualReleaseDate = movie.getReleaseDate();

        // Then
        assertEquals(releaseDate, actualReleaseDate);
    }

    @Test
    void setReleaseDate() {
        // Given
        Movie movie = new Movie(null, null, null, null, 0);
        LocalDate newReleaseDate = LocalDate.of(2023, 5, 10);

        // When
        movie.setReleaseDate(newReleaseDate);
        LocalDate actualReleaseDate = movie.getReleaseDate();

        // Then
        assertEquals(newReleaseDate, actualReleaseDate);
    }

    @Test
    void getBudget() {
        // Given
        double budget = 1000000.00;
        Movie movie = new Movie(null, null, null, null, budget);

        // When
        double actualBudget = movie.getBudget();

        // Then
        assertEquals(budget, actualBudget);
    }

    @Test
    void setBudget() {
        // Given
        Movie movie = new Movie(null, null, null, null, 0);
        double newBudget = 1500000.00;

        // When
        movie.setBudget(newBudget);
        double actualBudget = movie.getBudget();

        // Then
        assertEquals(newBudget, actualBudget);
    }
}
