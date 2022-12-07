/*
Class to write code in the lecture
 */
package week12.topic13_threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ajb
 */
public class WorkingCode extends Thread{
    int start;
    int end;
    WorkingCode other;
    
    public void connect(WorkingCode w){
        other=w;
    }
    
    
    WorkingCode(int s,int e){
        start=s;
        end=e;
    }
    public void run(){
        if(other != null)
            try {
                other.join();
        } catch (InterruptedException ex) {
                System.out.println("EXCEPTION!!!!!");
                System.exit(0);
        }
        process();
        
    }
    
    void process(){
        for(int i=start;i<=end;i++){
            System.out.println(" DOING TASK "+i);
        }
        
        
    }
    public static void main(String[] args){

        
        int processes = Runtime.getRuntime().availableProcessors();
        long memory= Runtime.getRuntime().freeMemory();
        System.out.println("Processes available ="+processes+" has memory ="+memory);
        long start =System.nanoTime();
        int max=100000;
        WorkingCode sequential = new WorkingCode(1,max);
//        sequential.process();
        long end =System.nanoTime();
        long s=end-start;
        start =System.nanoTime();
        WorkingCode[] c= new WorkingCode[4];
        c[0]=new WorkingCode(1,max/4);
        c[1]=new WorkingCode(max/4+1,max/2);
        c[2]=new WorkingCode(max/2+1,3*max/4);
        c[3]=new WorkingCode(3*max/4+1,max);
        
        c[0].connect(c[3]);
        for(int i=0;i<c.length;i++)
                c[i].start();

        
        try {
            for(int i=0;i<c.length;i++)
                c[i].join();
        }catch (InterruptedException ex) {
                Logger.getLogger(WorkingCode.class.getName()).log(Level.SEVERE, null, ex);
        }
       end =System.nanoTime();
        System.out.println(" Sequential time ="+s);
        System.out.println(" Concurrent time ="+(end-start));
  
    }
    
}
