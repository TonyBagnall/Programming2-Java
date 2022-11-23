package week7.topic3_iterators.movies;
/**
 * Topic 3: Iterators (lecture week 7)
 * Note the code is not polished! You should write better code with comments, proper encapsulation etc
 *
 * Implement an Iterator for MovieDatabase
 */

import java.util.Iterator;

public class MovieIterator implements Iterator<Movie> {
    MovieDatabase m;
    int pos;
    MovieIterator(MovieDatabase m){
        this.m=m;
        pos=0;
    }

    @Override
    public boolean hasNext() {
        if(pos<m.size())
            return true;
        return false;
    }

    @Override
    public Movie next() {
        Movie movie=m.movies[pos];
        pos++;
        return movie;
    }
}
