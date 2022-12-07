

package week12.topic13_threads;

import java.util.Arrays;
import java.util.Random;

public class ThreadSort extends Thread {
    public static Comparable[] data;
    int start;
    int end;

    public ThreadSort(int s, int e) {
        start = s;
        end = e;
    }

    public void run() {
        Arrays.sort(data, start, end);
    }

    public static Comparable[] temp;

    /**
     * Merge the sorted regions (a,b) and (c,d) into (a,d) so that (a,d)
     * is sorted
     */
    public static void merge(int a, int b, int c, int d) {
//More efficient to use a single memory temp.     
        Comparable[] merged = new Comparable[(b - a) + (d - c)];
        int pos = 0;
        int left = a;
        int right = c;
        while (left < b && right < d) {
            int comp = data[left].compareTo(data[right]);
            if (comp < 0) {  //Left less than right
                merged[pos] = data[left];
                left++;
            } else {
                merged[pos] = data[right];
                right++;
            }
            pos++;
        }
//Finish off left or right    
        while (left < b) {
            merged[pos] = data[left];
            pos++;
            left++;
        }
        while (right < d) {
            merged[pos] = data[right];
            right++;
            pos++;

        }
//Copy back to the array
        for (int i = a; i < merged.length; i++)
            data[i] = merged[i - a];

    }

    public static void main(String[] args) throws Exception{
        int m = 100;
        data = new Comparable[m];
        int numThreads = 10;
        Random rf = new Random();
        ThreadSort[] arr = new ThreadSort[numThreads];
//Get data to be sorted
        for (int i = 0; i < m; i++)
            data[i] = new Integer(rf.nextInt() % 100);
//Create n threads, each with sub array to sort
        for (int i = 0; i < numThreads; i++) {
            System.out.println("Thread "+i+" sorts from "+
                    i*m/numThreads+" to " + ((i+1)*m/numThreads));
            arr[i] = new ThreadSort(i * m/numThreads, (i+1)*m/numThreads);
            arr[i].start();
        }
        //need joins here to stop premature merging
        for(int i=0;i<numThreads;i++)
            arr[i].join();
//Merge back together
        for (int i = 0; i < numThreads - 1; i++)
            merge(0,(i+1)*m/numThreads,(i+1)*m/numThreads, (i+2)*m/numThreads);
        System.out.println(" Array is sorted =" + isSorted(data));
 //       for(Comparable c:data)
 //           System.out.println(c);






    }
public static boolean isSorted(Comparable[] c){
    for(int i=0;i<c.length-1;i++)
        if(c[i].compareTo(c[i+1])>0) return false;
    return true;
    
}
}