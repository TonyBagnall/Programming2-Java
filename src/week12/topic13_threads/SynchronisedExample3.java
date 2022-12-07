
package week12.topic13_threads;
import java.util.*;

public class SynchronisedExample3 extends Thread{
    public static ArrayList<String> synchronisedSharedMemory=new ArrayList<>();
    public static ArrayList<String> unsynchronisedSharedMemory=new ArrayList<>();
    public static long startTime=System.nanoTime();
    int id;
    enum ExampleType{BLOCKSYNC,METHODSYNC}
    ExampleType et=ExampleType.BLOCKSYNC;
    public void setExampleType(ExampleType e){et=e;}
    SynchronisedExample3(int id){
        this.id=id;
    }
    public void run(){
        try{
            if(et==ExampleType.BLOCKSYNC){
                for(int i=0;i<3;i++){ //Add to the end unsynchronised
                    sleep((long)((10-2*(i+1))*Math.random()*1000));
                    unsynchronisedSharedMemory.add(id+":"+i);
                }
                synchronized(synchronisedSharedMemory){
                    for(int i=0;i<3;i++){ //Add to the end synchronised
                        sleep((long)((10-2*(i+1))*Math.random()*1000));
                        synchronisedSharedMemory.add(id+"::"+i);
                    }
                }
            }
            else if(et==ExampleType.METHODSYNC){ //Same as previous, but with synchronised methods
                add();
                add2();
            }
            }catch(Exception e){
                System.out.println("Exception thrown ="+e);
                e.printStackTrace();
                System.exit(0);
            }
    }
    public void add() throws Exception{
        for(int i=0;i<3;i++){ //Add to the end synchronised
            sleep((long)((10-2*(i+1))*Math.random()*1000));
        unsynchronisedSharedMemory.add(id+":"+i);

        }
    } 
    synchronized public void add2() throws Exception{
        for(int i=0;i<3;i++){ //Add to the end synchronised
            sleep((long)((10-2*(i+1))*Math.random()*1000));
        unsynchronisedSharedMemory.add(id+":"+i);

        }
    } 

    
}
