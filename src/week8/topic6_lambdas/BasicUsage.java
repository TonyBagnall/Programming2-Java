package week8.topic6_lambdas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * 1. Lambdas as an alternative to anonymous inner classes
 * 2. Lambdas as arguments to functions
 */
public class BasicUsage {

    public static void main(String[] args) {
        Movie[] movies = new Movie[2];
        movies[0] = new Movie("FOO",1999, Movie.FilmType.COMEDY);
        movies[1] = new Movie("BAR",2022, Movie.FilmType.ACTION);

        for(Movie m: movies)
            System.out.println(m);
        int a = movies[0].compareTo(movies[1]);
        System.out.println(" Built in compareTo = "+a);
        Comparator<Movie> cmp = new Movie.MovieCompareType();
        int b = cmp.compare(movies[0],movies[1]);
        System.out.println(" Comparator in the Movies class = "+b);
        Comparator<Movie> myCmp = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                if(o1.year < o2.year)
                    return -1;
                else if(o1.year > o2.year)
                    return 1;
                else{
                    return o2.compareTo(o1);
                }
            }
        };
        int c = myCmp.compare(movies[0],movies[1]);
        System.out.println(" Anonymous Comaprator = "+c);
        ActionListener al  =(ActionEvent e)-> System.out.println("Helle");
        Comparator<Movie> myLambda = (Movie o1,Movie o2) ->{return(o2.year -o1.year);};

        int d= myLambda.compare(movies[0],movies[1]);
        System.out.println(" Lambda comparator = "+d);
        Comparator<Movie> myLambda2 = (o1, o2) -> {
            int y = o1.year - o2.year;
            if(y==0)
                return o2.compareTo(o1);
            return y;
        };

    }
}
