package week7.topic3_iterators.movies;

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
        Comparator<Movie> cmp = new MovieCompareYear();
        Arrays.sort(movies,cmp);
        System.out.println(" Post sort by year");
        for(Movie m: movies)
            System.out.println(m);
        MovieDatabase imdb = new MovieDatabase();
        imdb.addMovies(movies);
        System.out.println(" Iteration of move database imdb");
        MovieIterator it = new MovieIterator(imdb);
        while(it.hasNext())
            System.out.println(it.next());
        System.out.println(" Iterable interface");
       for(Movie m: imdb)
            System.out.println(m);

    }
}
