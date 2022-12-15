package week12;

import java.util.ArrayList;
import java.util.Random;

public class SynchEx3 extends Thread {
    static ArrayList<Integer> shared = new ArrayList<>();
    static ArrayList<Integer> shared2 = new ArrayList<>();
    static ArrayList<Integer> shared3 = new ArrayList<>();
    String name;
    public SynchEx3(String s){
        name=s;
    }
    public void run(){
        Random r = new Random();
        for(int i=0;i<1000;i++) {
            synchronized (SynchEx3.class) {
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
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchEx1 x1= new SynchEx1("Bob");
        SynchEx1 x2= new SynchEx1("Alice");
        x1.start();
        x2.start();
        x1.join();
        x2.join();
        System.out.println(" Size of shared = "+shared.size());
    }

}
