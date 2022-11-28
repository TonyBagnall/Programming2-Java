package week8.topic4_nested_classes.movies;
/**
 * Topic 3: Iterators. Demonstrate the difference between Iterator and Iterable
 */

import java.util.ArrayList;
import java.util.Iterator;

public class MovieDatabase implements Iterable<Movie>{
    private Movie[] movies;
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

    private boolean backwards = false;
    public void setGoBackward(){
        backwards=true;
    }
    @Override
    public Iterator<Movie> iterator() {
        if(backwards)
            return new MovieBackwardsIterator();
        return new MovieIterator();
    }

    private class MovieIterator implements Iterator<Movie> {
        int pos;
        MovieIterator(){
            pos=0;
        }
        @Override
        public boolean hasNext() {
        if(pos<currentSize)
            return true;
        return false;
        }
        @Override
        public Movie next() {
           return movies[pos++];
        }
    }

    private class MovieBackwardsIterator implements Iterator<Movie> {
        int pos;
        MovieBackwardsIterator(){
            pos=currentSize-1;
        }
        @Override
        public boolean hasNext() {
            if(pos>=0)
                return true;
            return false;
        }
        @Override
        public Movie next() {
            return movies[pos--];
        }
    }





}
