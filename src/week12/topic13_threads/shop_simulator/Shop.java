/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week12.topic13_threads.shop_simulator;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author ajb
 */
public class Shop extends Thread{
    private HashSet<String> goods= new HashSet<>();
    volatile boolean open=true;
    public static String goodsList="ABCDEFGHILKLM";
    public static Random r = new Random();
    public Shop(){
        restock();
        for(String s:goods)
            System.out.print(s);
        System.out.print("\n");
    }
    public void run(){
        while(open){
            //Check stock levels
            if(goods.size()<goodsList.length()/2) //Reorder
                restock();
        }
    }


    public boolean search(String s){
        return goods.contains(s);
	}
	public boolean buy(String s){
        if(!goods.contains(s)) return false;

        synchronized(goods) {
            goods.remove(s);
        }
        return true;
	}



    public  void restock(){
        for (int i=0;i<goodsList.length();i++){
            String s="";
            s+=goodsList.charAt(i);
            goods.add(s);
            System.out.println(" Adding good "+s);
        }
            
    }       
}
