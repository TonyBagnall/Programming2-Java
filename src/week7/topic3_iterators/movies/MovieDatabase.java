package week7.topic3_iterators.movies;
/**
 * Topic 3: Iterators. Demonstrate the difference between Iterator and Iterable
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase implements Iterable<Movie>{
    public Movie[] movies;
    private int max=100;
    private int currentSize=0;
    public MovieDatabase(){
        movies=new Movie[max];
    }
    public void addMovie(Movie m){
        movies[currentSize]=m;
        currentSize++;
    }
    public int size(){ return currentSize;}
    public void setMovies(Movie[] arr){
        for(int i=0;i<arr.length;i++)
            movies[i]=arr[i];
        currentSize=arr.length;
    }
    public void addMovies(Movie[] arr){
        for(int i=0;i<arr.length;i++)
            movies[currentSize+i]=arr[i];
        currentSize+=arr.length;
    }


    public static void main(String[] args) {
        ArrayList<String> arr= new ArrayList<>();
        arr.add("Up");
        arr.add("The");
        arr.add("Arsenal!");
        for(String s:arr)
            System.out.println(s);
        Movie[] myMovies = Movie.exampleArray();
        for(Movie n:myMovies)
            System.out.println(n);

    }


    @Override
    public Iterator<Movie> iterator() {
        return new MovieIterator(this);
    }
}
