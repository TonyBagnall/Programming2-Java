package week12;

import java.util.ArrayList;

public class SynchEx1 extends Thread {
    static ArrayList<Integer> shared = new ArrayList<>();
    String name;
    public SynchEx1(String s){
        name=s;
    }
    public void run(){
            for(int i=0;i<100;i++) {
                synchronized (shared) {
                    if (!shared.contains(i))
                        shared.add(i);
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
