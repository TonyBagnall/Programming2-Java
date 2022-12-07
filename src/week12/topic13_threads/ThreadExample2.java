/*
Thread Example 2, storing references to other threads
 */

package week12.topic13_threads;

public class ThreadExample2 extends Thread{
    ThreadExample2 otherThread=null;
    public String threadName;
    public void connect(ThreadExample2 t){
        otherThread=t;
    }
    public ThreadExample2(String s){
        threadName=s;
    }
    
    @Override
    public void run(){   
       for(int i=0;i<=40000;i++)
           if(i%10000==0)
               System.out.println(threadName+" FIRST HALF iteration "+i);
        if(otherThread!=null){
            try{
                otherThread.join();
            }catch(InterruptedException e){
                System.err.println(" Error in thread "+e);
            }
        }
       for(int i=40001;i<=80000;i++)
           if(i%10000==0)
               System.out.println(threadName+"\t\t\t SECOND HALF iteration "+i);
    }
    
    public static void main(String[] args) throws Exception{
     ThreadExample2 t1=new ThreadExample2(" Thread 1");
     ThreadExample2 t2=new ThreadExample2(" Thread 2");
     ThreadExample2 t3=new ThreadExample2(" Thread 3");
     t1.connect(t3);
     t3.connect(t1);
     //t1 will now wait for t3 to finish before the second set of 
     //print outs. 

        t1.start();
     t2.start();
     t3.start();
     t1.join();
     t2.join();
     t3.join();

    }

    

}
