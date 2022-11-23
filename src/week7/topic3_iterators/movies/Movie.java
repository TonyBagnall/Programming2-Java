package week7.topic3_iterators.movies;

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
    String name;
    public int year;     // Year of release
    int type;       // 0 == action, 1 == comedy, 2 == horror: Come back to with topic 5: enum types

    public Movie(String s, int y, int t){
        name=s;
        year=y;
        type =t;
    }

    public static Movie[] exampleArray(){
        Movie[] m = new Movie[4];
        m[0] = new Movie("Unforgiven", 1994,0);
        m[1] = new Movie("Life of Brian", 1979, 1);
        m[2] = new Movie("Goodfellas", 1990,1);
        m[3] = new Movie("Alien",1979,2);
        return m;
    }

    public static void main(String[] args) {
        Movie n=new Movie("Unforgiven", 1994,0);
        Movie[] myFilms = exampleArray();
// Use Comparable
//        Arrays.sort(myFilms);
// Create Comparators
//        Arrays.sort(myFilms, //Add comparator);
    }

    @Override
    public int compareTo(Movie bob) {
        return name.compareTo(bob.name);
    }
    @Override
    public String toString(){
        return name+","+year+","+type;
    }
}
