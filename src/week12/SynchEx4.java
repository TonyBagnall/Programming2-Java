package week12;

import java.util.ArrayList;
import java.util.Random;

public class SynchEx4 {
    static ArrayList<Integer> shared = new ArrayList<>();
    static ArrayList<Integer> shared2 = new ArrayList<>();
    static ArrayList<Integer> shared3 = new ArrayList<>();
    String name;
    public SynchEx4(String s){
        name=s;
    }
    public synchronized static void addRandom(int i){
        Random r = new Random();
        int rand = r.nextInt(3);
        if (rand == 0) {
            if (!shared.contains(i))
                shared.add(i);
        } else if (rand == 1) {
            if (!shared2.contains(i))
                shared2.add(i);
        } else if (rand == 2) {
            if (!shared3.contains(i))
                shared3.add(i);
        }

    }
    public void run(){
        for(int i=0;i<1000;i++) {
                addRandom(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
    }

}
