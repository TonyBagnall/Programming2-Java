package week12.topic13_threads;

import java.util.ArrayList;
import java.util.HashSet;


public class SynchronizedExample1 extends Thread{
    NestedSynchExample testy;
    public void setTesty(NestedSynchExample t){
        testy=t;
    }


    //Shared memory: Class variable
    public static ArrayList<Integer> sharedMemory=new ArrayList<>();
    public static ArrayList<Integer> moreSharedMemory=new ArrayList<>();
    //Local memory: Object variable
    SynchronizedExample1 otherThread;
    String name;
    HashSet<String> names;
    public ArrayList<Integer> scores;
    public SynchronizedExample1(String n){
        name=n;
    }




    public static class NestedSynchExample {
        HashSet<String> names=new HashSet<>();
        HashSet<String> dates=new HashSet<>();
        boolean addName (String s){
            boolean b=false;
            synchronized(names){
                 b=names.add(s);
            }
            return b;
        }

        synchronized boolean addName2 (String s){
            return names.add(s);
        }





        boolean addIfDate(String d, String n){
            if(dates.contains(d))
                return names.add(n);
            return false;
        }


        boolean addIfDate2(String d, String n){
            if(dates.contains(d))
                synchronized(names) {
                    return names.add(n);
                }
            return false;
        }


    }
    @Override
    public void run(){
        for(int i=0;i<400;i++)
            testy.addName2("Foo"+i);
    }
    public static void synchMethodExample() throws Exception {
        SynchronizedExample1 first = new SynchronizedExample1("First");
        SynchronizedExample1 second = new SynchronizedExample1("Second");
        NestedSynchExample testy = new NestedSynchExample();
        first.setTesty(testy);
        second.setTesty(testy);
        first.start();
        second.start();
        first.join();
        second.join();
        System.out.println("size = " + testy.names.size());
//        System.exit(0);
    }
    public static void main(String[] args) throws Exception{
        synchronized (SynchronizedExample1.class){


        }


        synchMethodExample();
        System.exit(0);

        int nosThreads=10;
        ArrayList<SynchronizedExample1> ex= new ArrayList<>();
        for(int i=0;i<nosThreads;i++){
            SynchronizedExample1 temp=new SynchronizedExample1("Thread"+i);
            ex.add(temp);
        }
        for(int i=0;i<ex.size();i++)
            ex.get(i).start();
        /*Note dont join before running them all!*/
        try{
            for(int i=0;i<ex.size();i++)
                ex.get(i).join();
        }catch(InterruptedException e){
            System.out.println(" Exception ="+e);
            System.exit(0);
        }
//Spossible synchronisation removes the possible interference
        if(!checkArray(sharedMemory)){
            System.out.println("ERROR IN ARRAY");
            for(Integer i:sharedMemory)
                System.out.println(i);
        }
        else
            System.out.println("ALL OK");
    }







    public void foo(){
        synchronized(sharedMemory) {
            if (!sharedMemory.contains(33))
                sharedMemory.add(33);
        }
        synchronized(names){
            names.add("BOB");
        }
        synchronized(this){
            names.add("BOB");
        }
    }

    public void add(Integer i){

        synchronized(sharedMemory) {
            if (!sharedMemory.contains(i))
                sharedMemory.add(i);
        }
    }



    public static boolean checkArray(ArrayList<Integer> arr){
      int prev=arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)!=prev+10)
                return false;
            prev=arr.get(i);
        }
        return true;
    }


    //Synchronisation via synchronised methods.
    public static synchronized boolean addIfNotPresent(Integer i){
        boolean contains=sharedMemory.contains(i); //Access shared memory exclusively
        if(!contains)
            sharedMemory.add(i);     //Change shared memory exclusively
        return contains;
    }

 public static synchronized void synchAdd(Integer i){
        if(!sharedMemory.contains(i)) //Access shared memory
            sharedMemory.add(i);     //Change shared memory


    }
}
