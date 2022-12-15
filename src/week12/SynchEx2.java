package week12;

import java.util.ArrayList;

public class SynchEx2 {
    ArrayList<Integer> objectShared = new ArrayList<>();

    public boolean contains(Integer i){
        return objectShared.contains(i);
    }
    public synchronized void add(Integer i){
        if(!objectShared.contains(i))
            objectShared.add(i);
    }
    public static class Nested extends Thread{
        SynchEx2 x;
        Nested(SynchEx2 s){
            x=s;
        }
        public void run(){
             for(int i=0;i<100;i++) {
                         x.add(i);
            }
        }

    }
    public static void main(String[] args) throws InterruptedException {
        SynchEx2 shared = new SynchEx2();
        Nested x1 = new Nested(shared);
        Nested x2 = new Nested(shared);
        x1.start();
        x2.start();
        x1.join();
        x2.join();
        System.out.println(" Size of shared = "+shared.objectShared.size());
    }


}
