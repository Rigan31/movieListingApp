package Components;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {
    private List<Movie> movies;

    public MovieRepository() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> searchMovies(String keyword) {
        List<Movie> searchResults = new ArrayList<>();
        keyword = keyword.toLowerCase(); // Convert keyword to lowercase for case-insensitive comparison

        for (Movie movie : movies) {
            // Check if movie title contains the keyword
            if (movie.getTitle().toLowerCase().contains(keyword)) {
                searchResults.add(movie);
                continue; // Move to the next movie
            }

            // Check if any actor name contains the keyword
            boolean actorFound = false;
            for (String actor : movie.getCast()) {
                if (actor.toLowerCase().contains(keyword)) {
                    searchResults.add(movie);
                    actorFound = true;
                    break; // Move to the next movie
                }
            }
            if (actorFound) continue; // Move to the next movie

            // Check if category contains the keyword
            if (movie.getCategory().toLowerCase().contains(keyword)) {
                searchResults.add(movie);
            }
        }

        // Sort the search results by movie title
        searchResults.sort(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER));

        return searchResults;
    }

}
