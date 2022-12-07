/*
 THREADS
 */
package week12.topic13_threads;

import java.util.ArrayList;

/**
 *
 * @author ajb
 */
public class FurtherSleepExample {
    public static void sleepExample1(){
        //Example 1: simple two thread interaction
        SleepInterruptExample s1=new SleepInterruptExample("Thread A");
        SleepInterruptExample s2=new SleepInterruptExample("Thread B");
        s1.connect(s2);
        s2.connect(s1);
        s1.start();
        s2.start();
    }
    public static void sleepExample2() throws InterruptedException {
        long patience = 1000 * 30;  //30 seconds
        long startTime = System.currentTimeMillis();
        MessageLoopExample t = new MessageLoopExample();
        t.start();
        while (t.isAlive()) {
            System.out.println("Still waiting...");
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
                    System.out.println("Tired of waiting!");
                    t.interrupt();
                    t.join();
            }
        }
        System.out.println("Finally!");
        
}


    
    public static void synchronisedExample (SynchronisedExample3.ExampleType se) throws Exception{
        
        SynchronisedExample3.synchronisedSharedMemory=new ArrayList<>();
        SynchronisedExample3.unsynchronisedSharedMemory=new ArrayList<>();
        
        SynchronisedExample3[] s=new SynchronisedExample3[10];
        for(int i=0;i<3;i++){
            s[i]=new SynchronisedExample3(i);
            s[i].setExampleType(se);
        }
        for(int i=0;i<3;i++)
            s[i].start();
        for(int i=0;i<3;i++)
            s[i].join();
        System.out.println("So we have synchronised within the run method, but there can still be uncertainy between the threads");
        System.out.println("**************Synchronised Mememory******************");
        for(String str : SynchronisedExample3.synchronisedSharedMemory)
            System.out.println(str);
        System.out.println("**************Unsynchronised Mememory******************");
        for(String str : SynchronisedExample3.unsynchronisedSharedMemory)
            System.out.println(str);
    }
        
    
    public static void main(String[] args){
//Note if you uncomment the first call, all the threads are intermixed!        
//         sleepExample1();
         try{
 //            sleepExample2();
             synchronisedExample(SynchronisedExample3.ExampleType.BLOCKSYNC);
             synchronisedExample(SynchronisedExample3.ExampleType.METHODSYNC);
         }catch(Exception e){
             System.out.println("Exception thrown ="+e);
             e.printStackTrace();
         
         }  
    }
}
