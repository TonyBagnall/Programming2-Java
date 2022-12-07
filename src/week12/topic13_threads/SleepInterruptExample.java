/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.topic13_threads;

/**
 *
 * @author ajb
 */
public class SleepInterruptExample extends Thread{
    SleepInterruptExample other;
    String t;
    public SleepInterruptExample(String name){
        t=name;
    }
    public void connect(SleepInterruptExample o){
        other=o;
        
    }
    @Override
    public void run(){ 
  int completedSleeps=0;
  while(completedSleeps<5){
	try{
         sleep((long)(Math.random()*1000));
         System.out.println(t+" IS INTERRUPTING "+other.t);
	  other.interrupt();
	  completedSleeps++;
          System.out.println(t+" has completed "+completedSleeps+" sleeps");


	}catch(InterruptedException e){
         System.out.println("\t\t"+t+" HAS BEEN INTERRUPTED BY  "+other.t+" completed sleeps ="+completedSleeps);
        }
    }
    }
}
