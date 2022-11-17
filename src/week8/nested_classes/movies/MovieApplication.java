package week8.nested_classes.movies;

/**
 * Topic 3:
 * Note the code is not polished! You should write better code with comments, proper encapsulation etc
 *
 *  Learning outcome for this package:
 */
public class MovieApplication {

    public static void main(String[] args) {
        MovieDatabase imdb = new MovieDatabase();
        Movie[] movies = Movie.exampleArray();
        imdb.addMovies(movies);
        for(Movie m: movies)
            System.out.println(m);
        MovieIterator it = new MovieIterator(imdb);
        while(it.hasNext())
            System.out.println(it.next());
//        for(Movie m: imdb)
//            System.out.println(m);

    }
}
