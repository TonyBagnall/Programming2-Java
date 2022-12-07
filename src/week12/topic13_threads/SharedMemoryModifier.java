
package week12.topic13_threads;

public class SharedMemoryModifier extends Thread{
    SharedMemory names;
    SharedMemoryModifier(SharedMemory n){
        names=n;
    }
    public void run(){
        synchronized(SharedMemory.class){
// owns the monitor lock of names            
        }
    }
    
}
