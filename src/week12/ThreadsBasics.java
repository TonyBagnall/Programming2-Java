package week12;

import java.util.Random;

public class ThreadsBasics extends Thread{
    String name;
    ThreadsBasics(String n){
        name=n;
    }
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(name +" "+ i);
            try {
                sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadsBasics x1 = new ThreadsBasics("ALICE");
        ThreadsBasics x2 = new ThreadsBasics("BOB");
        x1.start();
        x2.start();
        x1.join();
        x2.interrupt();
        for(int i=0;i<10;i++)
            System.out.println(" IN MAIN "+i);

    }
}
