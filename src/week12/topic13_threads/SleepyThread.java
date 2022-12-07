

package week12.topic13_threads;

/**
 *
 * @author ajb
 */
public class SleepyThread extends Thread {
  String t;
  SleepyThread(String temp){ t=temp;}

    @Override
    public void run() {
        long time = 0;
        for (int i = 0; i < 10; i++) {
            try {
                time = (long) (Math.random() * 1000);
                System.out.println("thread " + t + " iteration " + i);
                System.out.println(" sleeping for " + time);
                sleep(time);
            } catch (InterruptedException e) {
                System.out.println("\t\tSleep has been interrupted for thread =" + t + " at iteration " + i);
            }
        }
    }
   public static void simpleSleep(){
      SleepyThread x=new SleepyThread ("A");
      SleepyThread y=new SleepyThread ("B");
      x.start();
	  y.start();
   }
   public static void interruptedSleep(){
       	SleepyThread x=new SleepyThread ("A");
	SleepyThread y=new SleepyThread ("B");
	x.start();
	y.start();
//Randomly interrupt one of the threads        
        for(int i=0;i<10;i++){
            try{
                sleep(500);

                if(Math.random()<0.5)
                    x.interrupt();
                else
                    y.interrupt();
            }catch(InterruptedException e){
                System.out.println("What can interrupt the main thread?");
                System.exit(0);
            }
            
        }
        
        
   }
   
   public static void main(String[] args){
 //      simpleSleep();
       interruptedSleep();
   }
   
   
    
}
