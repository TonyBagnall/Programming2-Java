/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.topic13_threads;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author ajb
 */
public class ExecutorExample extends Thread{
    String name;
    public ExecutorExample(String str){
        name=str;
    }
    public void run(){
        System.out.println("Starting thread "+name);
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
        System.out.println("Interrupted!");
        }
        System.out.println("Ending thread "+name);
    }
    
    public static void main(String[] args) {
    ArrayList<Runnable> experiments = new ArrayList<>();
    int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Cores = "+cores);
    for(int i=0;i<100;i++)
        experiments.add(new ExecutorExample("Thread "+(i+1)));
    ExecutorService executor = Executors.newFixedThreadPool(cores);
    for(Runnable r:experiments)
            executor.execute(r);

    while (!executor.isTerminated()) {
    //Wait for all jobs to finish
    }
    
    
    }
}
