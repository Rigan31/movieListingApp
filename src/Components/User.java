package Components;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String gender;
    private LocalDate accountCreationDate;
    private List<Movie> favorites;

    public User(String email) {
        this("", email, "");
    }

    public User(String name, String email) {
        this(name, email, "");
    }

    public User(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.accountCreationDate = LocalDate.now();
        this.favorites = new ArrayList<>();
    }

    public void addToFavorites(Movie movie) {
        if (!favorites.contains(movie)) {
            favorites.add(movie);
            System.out.println(movie.getTitle() + " added to favorites.");
        } else {
            System.out.println(movie.getTitle() + " is already in favorites.");
        }
    }

    public void removeFromFavorites(Movie movie) {
        if (favorites.contains(movie)) {
            favorites.remove(movie);
            System.out.println(movie.getTitle() + " removed from favorites.");
        } else {
            System.out.println(movie.getTitle() + " is not in favorites.");
        }
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public String getEmail(){
        return email;
    }

    public void displayFavorites() {
        if (!favorites.isEmpty()) {
            System.out.println("\nFavorite Movies:");
            for (Movie movie : favorites) {
                System.out.println(movie);
            }
        } else {
            System.out.println("No favorite movies found.");
        }
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nEmail: %s\nGender: %s\nAccount Creation Date: %s\nFavorites Count: %d\n",
                name, email, gender, accountCreationDate.toString(), favorites.size());
    }
}
