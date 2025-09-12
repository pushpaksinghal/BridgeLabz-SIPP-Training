import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + releaseYear;
    }
}

public class TopMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2022),
            new Movie("Movie B", 9.0, 2023),
            new Movie("Movie C", 7.8, 2021),
            new Movie("Movie D", 9.2, 2023),
            new Movie("Movie E", 8.9, 2022),
            new Movie("Movie F", 9.5, 2024),
            new Movie("Movie G", 8.7, 2024)
        );

        List<Movie> top5 = movies.stream()
            .filter(m -> m.releaseYear >= 2022) 
            .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                    .thenComparingInt(m -> m.releaseYear).reversed())

            .limit(5)
            .collect(Collectors.toList());

        top5.forEach(System.out::println);
    }
}
