package week7.topic3_iterators.movies;

import java.util.Comparator;

public class MovieCompareYear implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.year - o2.year;
    }
}
