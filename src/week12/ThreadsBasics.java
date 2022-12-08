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
            System.out.println(name + i);
            try {
                sleep(r.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadsBasics x1 = new ThreadsBasics("ALICE");
        ThreadsBasics x2 = new ThreadsBasics("BOB");
//        x1.run();
//        x2.run();
        x1.start();
        x1.interrupt();
        x2.start();
        RunnableBasics y1 = new RunnableBasics("FRED");
        RunnableBasics y2 = new RunnableBasics("KATE");
        y1.run();
        y2.run();
        Thread t1 = new Thread(y1);
        Thread t2 = new Thread(y2);
        t1.start();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();






    }
}
