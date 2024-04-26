package Components;
import java.util.ArrayList;
import java.util.List;

public class MovieListingApp {
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    public MovieListingApp(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public List<Movie> searchMovies(String keyword) {
        return movieRepository.searchMovies(keyword);
    }

    public void addUser(String email) {
        userRepository.addUser(new User(email));
    }

    public User getUser(String email) {
        return userRepository.getUserByEmail(email);
    }

    public void addMovieToFavorites(User user, Movie movie) {
        if (user != null) {
            user.addToFavorites(movie);
        }
    }

    public void removeMovieFromFavorites(User user, Movie movie) {
        if (user != null) {
            user.removeFromFavorites(movie);
        }
    }

    public List<Movie> getFavoriteMovies(User user) {
        return user != null ? user.getFavorites() : new ArrayList<>();
    }
}
