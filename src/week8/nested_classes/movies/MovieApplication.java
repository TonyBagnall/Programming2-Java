package week8.nested_classes.movies;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Topic 3:
 * Note the code is not polished! You should write better code with comments, proper encapsulation etc
 *
 *  Learning outcome for this package:
 */
public class MovieApplication {

    public static void main(String[] args) {
        Movie[] movies = Movie.exampleArray();
        for(Movie m: movies)
            System.out.println(m);
//        Arrays.sort(movies);
        System.out.println(" Post sort");
        for(Movie m: movies)
            System.out.println(m);
        Comparator<Movie> cmp = new Movie.MovieCompareType();
        Arrays.sort(movies,cmp);
        class MyCmp implements Comparator<Movie>{
            @Override
            public int compare(Movie o1, Movie o2) {
                return 0;
            }

        }
        Comparator<Movie> myCmp = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return 0;
            }
        }


    }
}
