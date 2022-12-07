/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week12.topic13_threads;

/**
 *
 * @author ajb
 */
public class SynchronizedExample2 extends Thread{
    int runCount=0;
    private volatile boolean exit = false;
    public boolean  getExit(){
        return exit;}
    public  void setExit(boolean b){exit=b;}
//synchronized    
    @Override
    public void run() {
        while (!getExit()) {
            runCount++;
        }
        System.out.println("Thread terminated.");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample2 t = new SynchronizedExample2();
        t.start();
        Thread.sleep(1000);
        t.setExit(true);
        System.out.println("Attempted to to set exit to true.");
        Thread.sleep(1000);
        System.out.println("Thread t stillAlive ="+t.isAlive());
        if(t.isAlive()){
            for(int i=0;i<10;i++){
                Thread.sleep(1000);
                t.setExit(true);
                System.out.println("Attempted to to set exit to true."+t.exit);
                System.out.println("Thread t runcount ="+t.runCount);
            }       
        }
    }  
}
