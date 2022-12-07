/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package week12.topic13_threads.shop_simulator;

/**
 *
 * @author ajb
 */
public class Shopper extends Thread{
    @Override
    public void run(){
        while(s.open){
            //See if they have the good
            if(s.search(desiredGood)){

                boolean b=s.buy(desiredGood);
                System.out.print(" Shopper "+name+" tries to buy good "+desiredGood);
                if(!b)
                    System.out.println(" BUT FAILS");
                else
                    System.out.println(" AND SUCCEEDS");
                //Wait for a bit
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException e){

                }
            }
        }
    }

    private String name;
    private String desiredGood;
    Shop s;    
    public Shopper(String a, String b, Shop s){
        name =a;
        desiredGood =b;
        this.s=s;
    }
}
