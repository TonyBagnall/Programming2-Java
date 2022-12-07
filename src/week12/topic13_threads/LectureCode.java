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
public class LectureCode implements Runnable {
    int start;
    int end;
    String name;

    public LectureCode(int a, int b, String str) {
        start = a;
        end = b;
        name = str;
    }

    public void run() {
        for (int i = start; i < end; i++)
            System.out.println(name + "  " + i);

    }

    public static void main(String[] args) {

        System.out.println("Hello World");
        for (int i = 0; i < 100; i++)
            System.out.println("Print " + i);
        LectureCode l1 = new LectureCode(1, 50, "FOO");
        LectureCode l2 = new LectureCode(51, 100, "\t\tBAR");
//        l1.start();
//        l2.start();
        Thread t = new Thread(l1);
        t.start();
        new Thread(l2).start();
    }

    public class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 3; i++)
                System.out.println(" Thread Iteration " + i);

        }
    }
    public class MyRunnable implements Runnable {
        public void run() {
            for (int i = 0; i < 3; i++)
                System.out.println("\t Runnable Iteration " + i);

        }
    }

}