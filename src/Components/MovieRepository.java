package Components;

import java.util.ArrayList;
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
        return movies.stream()
                .filter(movie ->
                        movie.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                                movie.getCast().stream().anyMatch(actor -> actor.toLowerCase().contains(keyword.toLowerCase())) ||
                                movie.getCategory().toLowerCase().contains(keyword.toLowerCase()))
                .sorted((movie1, movie2) -> movie1.getTitle().compareToIgnoreCase(movie2.getTitle()))
                .collect(Collectors.toList());
    }
}
