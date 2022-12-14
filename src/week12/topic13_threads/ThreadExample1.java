
package week12.topic13_threads;

/* Thread example 1: Basic first example of threads and the use of
join for one thread to wait for another to finish
*/

public class ThreadExample1 extends Thread{
    public String threadName;
    public ThreadExample1(String s){
        threadName=s;
    }
    @Override
    public void run(){
        for(int i=0;i<100000;i++) {
            if (i % 10000 == 0) {
                for (int j = 0; j < id; j++)
                    System.out.print("\t ");
                System.out.println(threadName + " iteration " + i);
            }
        }
    }

    public int id=0;
    public void setID(int x){id=x;}

    public ThreadExample1(String name,int n){
        threadName=name;
        id=n;
    }

    public static void main(String[] args){
        ThreadExample1 t1=new ThreadExample1(" Thread 1");
        ThreadExample1 t2=new ThreadExample1(" Thread 2");
        System.out.println(" THREAD EXAMPLE 1");
        t1.start();
        t2.start();
        t1.setID(66);
       try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            System.out.println("EXIT with error "+e);
            System.exit(0);
        }
        for(int i=0;i<10000;i++)
            if(i%1000==0)
                System.out.println("Main Thread iteration:"+i);
        System.out.println(" FINISHED in MAIN");

    }
    
}
