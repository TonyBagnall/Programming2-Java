package Week9.topic7_number;

import java.util.ArrayList;
import java.util.HashSet;

public class BasicUsage {
    public static void main(String[] args) {
        //SHOW BOXING
        int x=33;
        Integer y = new Integer(x);
        y =55;
        Integer z = x+y;
        HashSet<Integer> myHash = new HashSet<>();
        myHash.add(4);
        myHash.add(x);
        ArrayList<Double> foo = new ArrayList<>();
        foo.add(33.0);
        double xxxx = foo.get(0);
        Number myNum  = -1;
        ArrayList<Number> foo2;
        int[] aa = new int[10];
        hello(aa);
        int a=10,b=11,c=13;
        world(a,b);
        world(a,b,c);


    }
    public static void hello(int[] a){
        for( int x:a)
            System.out.println(x);
    }
    public static void world(int ... a){
        for( int x:a)
            System.out.println(x);
    }
    //ELLIPSIS EXAMPLE

}
