package week10;

public class Pair <X extends Number,Y>{
    X key;
    Y data;
    public Pair(X k, Y d){
        key = k;
        data = d;
    }
}
