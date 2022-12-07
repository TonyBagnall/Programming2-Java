/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.topic13_threads;

/**
 *
 * @author ajb
 */
public class MessageLoopExample extends Thread {
public void run() {
            String song[] = {
            "I cant seem to face up to the facts",
                "I’m tense and nervous and I cant relax",
                "I can’t sleep cause my beds on fire",
                "Dont touch me Im a real live wire",
                "Psycho killer",
                "Quest que c’est?"};
 try {
  	     for(int i = 0;i<song.length;i++) {
                    //Pause for 4 seconds
                    Thread.sleep(4000);
                    System.out.println("\t\t"+song[i]);
		}
	}catch (InterruptedException e) {
		//Print "I wasn't done!"
            }
        }  
}
