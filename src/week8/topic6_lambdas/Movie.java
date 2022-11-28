package week8.topic6_lambdas;

import java.util.Comparator;

/**
 * Topic 2 and 3: Functors and Iterators (without nested classed)
 * Note the code is not polished! You should write better code with comments, proper encapsulation etc
 *
 *  Learning outcome for this package: understand the difference between Comparable and Comparator:
 *      1. Make Move Comparable, implement two Move Comparators. Comparators are a type of Functor.
        2. Show usage of both
        3. Show sorting an array
 */
public class Movie implements Comparable<Movie>{
    public String name;
    public int year;     // Year of release

    enum FilmType{ACTION,COMEDY,HORROR}

    FilmType type;

    double rating;
    public Movie(String s, int y, FilmType t){
        name=s;
        year=y;
        type =t;
    }
    public boolean myMethod(FilmType t){
        if(type==t)
            return true;
        return false;
    }
    public static Movie[] exampleArray(){
        Movie[] m = new Movie[4];
        m[0] = new Movie("Unforgiven", 1994,FilmType.ACTION);
        m[1] = new Movie("Life of Brian", 1979, FilmType.COMEDY);
        m[2] = new Movie("Goodfellas", 1990,FilmType.ACTION);
    m[3] = new Movie("Alien",1979,FilmType.HORROR);
        return m;
    }

    public static void main(String[] args) {
        Movie n=new Movie("Unforgiven", 1994,FilmType.ACTION);
        Movie[] myFilms = exampleArray();
        FilmType t = FilmType.COMEDY;

        // Use Comparable
//        Arrays.sort(myFilms);
// Create Comparators
//        Arrays.sort(myFilms, //Add comparator);
    }

    @Override
    public int compareTo(Movie o) {
        return 0;
    }
    //Nested comparators here

    public static class MovieCompareYear implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.year - o2.year;
        }
    }


    public static class MovieCompareName implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    public static class MovieCompareType implements Comparator<Movie> {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.type - o2.type;
        }
    }
    public String toString(){
        return name;
    }
}
