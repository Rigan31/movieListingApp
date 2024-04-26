import Components.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static MovieListingApp movieListingApp;
    private static User currentUser;

    public static void main(String[] args) {
        initializeApp();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMainMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    searchMovies();
                    break;
                case "4":
                    addMovieToFavorites();
                    break;
                case "5":
                    removeMovieFromFavorites();
                    break;
                case "6":
                    viewPersonalDetails();
                    break;
                case "7":
                    viewMovieDetails();
                    break;
                case "8":
                    searchFavoriteMovies();
                    break;
                case "9":
                    currentUser = null;
                    System.out.println("Logout successful.");
                    break;
                case "10":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    static MovieRepository createSampleMovieRepository() {
        MovieRepository movieRepository = new MovieRepository();

        return movieRepository;
    }

    static UserRepository createSampleUserRepository() {
        UserRepository userRepository = new UserRepository();
        
        return userRepository;
    }

    static void initializeApp() {
        MovieRepository movieRepository = createSampleMovieRepository();
        UserRepository userRepository = createSampleUserRepository();
        movieListingApp = new MovieListingApp(movieRepository, userRepository);
    }

    static void displayMainMenu() {
        System.out.println("-----------------------------------");
        System.out.println("Welcome to Movie Listing App");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Search Movies");
        System.out.println("4. Add Movie to Favorites");
        System.out.println("5. Remove Movie from Favorites");
        System.out.println("6. View Personal Details");
        System.out.println("7. View Movie Details");
        System.out.println("8. Search Favorite Movies");
        System.out.println("9. Logout");
        System.out.println("10. Exit");
        System.out.println("-----------------------------------");
        System.out.println();
        System.out.println("Please select an option: ");
    }

    static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser != null) {
            System.out.println("You are already logged in. Please logout to register a new user.");
            return;
        }
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        if (movieListingApp.getUser(email) != null) {
            System.out.println("User already exists. Please login.");
        } else {
            movieListingApp.addUser(email);
            System.out.println("Registration successful.");
            currentUser = movieListingApp.getUser(email);
        }
    }

    static void login() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser != null) {
            System.out.println("You are already logged in.");
            return;
        }
        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();
        if (movieListingApp.getUser(email) == null) {
            System.out.println("User not found. Please register first.");
        } else {
            System.out.println("Login successful.");
            currentUser = movieListingApp.getUser(email);
        }
    }

    static void searchMovies() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser == null) {
            System.out.println("Please login to search movies.");
            return;
        }
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        List<Movie> movies = movieListingApp.searchMovies(keyword);
        if (movies.isEmpty()) {
            System.out.println("No movies found.");
        } else {
            System.out.println("Search Results:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }

    static void addMovieToFavorites() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser == null) {
            System.out.println("Please login to add movies to favorites.");
            return;
        }
        System.out.print("Enter movie title to add to favorites: ");
        String title = scanner.nextLine();
        List<Movie> movies = movieListingApp.searchMovies(title);
        if (movies.isEmpty()) {
            System.out.println("Movie not found.");
        } else {
            Movie movie = movies.get(0); // Assuming there is only one movie with the given title
            movieListingApp.addMovieToFavorites(currentUser, movie);
            System.out.println(movie.getTitle() + " added to favorites.");
        }
    }

    static void viewMovieDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        List<Movie> movies = movieListingApp.searchMovies(title);
        if (movies.isEmpty()) {
            System.out.println("Movie not found.");
        } else if (movies.size() == 1) {
            System.out.println(movies.get(0));
        } else {
            System.out.println("Multiple movies found. Please refine your search.");
        }
    }

    static void removeMovieFromFavorites() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser == null) {
            System.out.println("Please login to remove movies from favorites.");
            return;
        }
        System.out.print("Enter movie title to remove from favorites: ");
        String title = scanner.nextLine();
        List<Movie> favoriteMovies = movieListingApp.getFavoriteMovies(currentUser);
        Movie movieToRemove = null;
        for (Movie movie : favoriteMovies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                movieToRemove = movie;
                break;
            }
        }
        if (movieToRemove != null) {
            movieListingApp.removeMovieFromFavorites(currentUser, movieToRemove);
            System.out.println(movieToRemove.getTitle() + " removed from favorites.");
        } else {
            System.out.println("Movie not found in favorites.");
        }
    }

    static void searchFavoriteMovies() {
        if (currentUser == null) {
            System.out.println("Please login to view favorite movies.");
            return;
        }
        System.out.println("Favorite Movies:");
        for (Movie movie : currentUser.getFavorites()) {
            System.out.println("- " + movie.getTitle());
        }
    }

    static void viewPersonalDetails() {
        if (currentUser == null) {
            System.out.println("Please login to view personal details.");
            return;
        }
        System.out.println("Email: " + currentUser.getEmail());
        System.out.println("Favorite Movies:");
        for (Movie movie : currentUser.getFavorites()) {
            System.out.println("- " + movie.getTitle());
        }
    }
}
