

package week12.topic13_threads;

import java.util.ArrayList;

/**
 * First shared memory example of threads. Note we will come
 * back to this when we look at synchronise. Rerun this repeatedly and you
 * will see some interference (null values in the array)
 */

public class ThreadExample3 extends Thread {




    //Shared memory
    public static ArrayList<Integer> sharedMemory = new ArrayList<>();
    //Local memory
    public String name;
    public static synchronized void add(Integer i) {
            if (!sharedMemory.contains(i)) //Access shared memory
                sharedMemory.add(i);     //Change shared memory
    }



    public void add2(Integer i) {
                synchronized(sharedMemory) {
                    if (!sharedMemory.contains(i)) //Access shared memory
                        sharedMemory.add(i);     //Change shared memory
               }
    }


    public ThreadExample3(String n) {
        name = n;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 400; i++)
            add(i);
    }

    public static void main(String[] args) {
        int nosThreads = 10;
        ArrayList<ThreadExample3> ex = new ArrayList<>();
        for (int i = 0; i < nosThreads; i++) {
            ThreadExample3 temp = new ThreadExample3("Thread" + i);
            ex.add(temp);
        }
        for (int i = 0; i < ex.size(); i++)
            ex.get(i).start();
        /*Note dont join before running them all!
         */
        try {
            for (int i = 0; i < ex.size(); i++)
                ex.get(i).join();
        } catch (InterruptedException e) {
            System.out.println(" Exception =" + e);
            System.exit(0);
        }

//Thread interaction with the shared memory will cause errors (sometimes!)        
//Check the array is correctly initialised

        try{
            boolean x=checkArray();
            if(x)
                System.out.println("correct");
            else{
                System.out.println("incorrect");
                for (Integer i : sharedMemory)
                    System.out.println(i);
            }
        }catch(Exception e){
            System.out.println("Exception");
            for(int i=1;i<sharedMemory.size();i++){
                if(sharedMemory.get(i)==sharedMemory.get(i-1))
                    System.out.println(" DUPLICATE "+i);
            }
            for (Integer i : sharedMemory)
                System.out.println(i);
        }

    }
    public static boolean checkArray() throws RuntimeException{
        for(int i=0;i<400;i++){
            if(sharedMemory.get(i)!=i)
                return false;
        }
        return true;
    }
}
