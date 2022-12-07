package week10;

import java.util.ArrayList;

public class Topic11BasicUsage {


    public static void main(String[] args) {
        //Raw types vs generics
        ArrayList meh = new ArrayList();
        meh.add("Hello");
        meh.add("33");
        meh.add(88);
        int [] x = new int[10];
        meh.add(x);
        meh.add(new ArrayList());
        testy(meh);
        ArrayList<Integer> xx;
        ArrayList<String> w;






        // Do a simple generic Pair class

        // Constraint on types for Pair

        // Relax constraints for references with wild cards

    }

    /**
     *
     * @param ar ArrayList of Integer
     * @return
     */
    public static int testy(ArrayList<Integer> ar){
        Integer sum=0;
        for(Integer s: ar) {
            sum += s;
        }
        return sum;
    }

}
