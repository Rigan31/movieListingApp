# Movie Listing Application
This is a simple console-based movie listing application where users can register with their email address, search for movies, view movie details, add/remove movies to/from their favorites, and view their personal details along with their favorite movies.

## Features
**User Registration:** Users can register with their email address. No authentication is required.

**Movie Search:** Users can search for movies by title, cast, or category. All matching movies are returned in ascending order of movie title.

**View Movie Details:** Users can see details for any movie, including movie title, cast, category, release date, and budget.

**Add to Favorites:** Users can add movies to their favorites list.

**Remove from Favorites:** Users can remove movies from their favorites list.

**View Personal Details:** Users can view their personal details along with the movies they added to their favorites.

**Search Favorites:** Users can search only the movies they added to their favorites.

## Classes
**Movie:** Represents a movie object with attributes like title, cast, category, release date, and budget.

**User:** Represents a user object with attributes like email address and favorite movies.

**MovieRepository:** Manages storage and retrieval of movie data.

**UserRepository:** Manages storage and retrieval of user data.

**MovieListingApp:** Main application class responsible for user interaction and managing user activities.

## Usage

To run the application, follow these steps:

Clone the repository:
```bash
git clone https://github.com/Rigan31/movieListingApp.git
```
Navigate to the directory:
```bash
cd movieListingApp
```
Run the application:
```bash
dotnet run
```
Once the application is running, users can interact with the menu displayed in the terminal to perform various actions such as registration, searching for movies, adding/removing movies from favorites, viewing personal details, etc.
To run the application, execute the provided C# console application file. Once the application is running, users can interact with the menu displayed in the terminal to perform various actions such as registration, searching for movies, adding/removing movies from favorites, viewing personal details, etc.

## Tests
Test cases have been implemented for each class to ensure the correctness and robustness of the application. These tests cover various scenarios such as user registration, movie search, adding/removing movies from favorites, etc. You can run the tests to verify the functionality of the application.

## Dependencies
This application does not have any external dependencies other than the standard libraries provided by the programming language used (C# in this case).

## Contributors
Md.Mahedi Hasan Rigan
