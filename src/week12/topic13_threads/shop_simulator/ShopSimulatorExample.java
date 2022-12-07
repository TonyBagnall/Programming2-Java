
package week12.topic13_threads.shop_simulator;

import static week12.topic13_threads.shop_simulator.Shop.goodsList;

/**
 *
 * @author ajb
 */
public class ShopSimulatorExample {
    public static void basicShop() throws Exception{
        Shop s= new Shop();
        Shopper[] c=new Shopper[10];
        for(int i=0;i<c.length;i++){
            c[i]=new Shopper("Shopper"+(i+1), ""+goodsList.charAt(i),s);
        }
        s.start();
        for(int i=0;i<c.length;i++)
            c[i].start();
        Thread.sleep(15000);
        System.out.println("Closing Shop");
        s.open=false;
    }
    public static void main(String[] args) throws Exception {
        basicShop();
    }
    
}
