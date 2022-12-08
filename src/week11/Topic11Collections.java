package week11;

import week7.topic1_interfaces.Student;
import week8.topic6_lambdas.Movie;

import java.util.*;

public class Topic11Collections {

    public static void main(String[] args) {
        String[] arr = new String[10];
        int position=0;
        for(int i=0;i<arr.length;i++)
            arr[i]= "Hello_"+i;
        arr[position++]="Hello";
        String str2="";
        for(int i=0;i<arr.length;i++)
            str2+=arr[i];
        ArrayList<String> arrList = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            arrList.add("Hello_"+i);
    String temp = arrList.get(5);
    arrList.set(5,"afc");
    for(String s: arrList)
        System.out.println(""+s);
    if(arrList.contains("HELLO"))
        System.out.println(" Hello!");




        //Collections:
// 1. Lists (ArrayList, LinkedList)
        List<String> myList = new LinkedList<>();



        //AbstractList
//        List<String> myL2 = new MyList<>();
//        List<String> myL2 = new SortedList<>();

// Use cases for lists: processing item

// 2. Sets (HashSet, TreeSet)
        HashSet<String> myHash = new HashSet<>();
        TreeSet<String> myTree = new TreeSet<>();
        myHash.add("BOB");
        myHash.add("ALICE");
        myHash.add("CLAIRE");
        myHash.add("DAVE");
        for(String s:myHash)
            System.out.println("hash = "+s);
        myHash.add("DAVE");
        for(String s:myHash)
            System.out.println("hash = "+s);
        myTree.add("BOB");
        myTree.add("ALICE");
        myTree.add("CLAIRE");
        myTree.add("DAVE");
        for(String s:myTree)
            System.out.println("tree = "+s);


// 3. Queues:
        Queue<String> myQueue = new LinkedList<>();
        Queue<String> myPriorityQueue = new PriorityQueue<>();

// 4. Maps
        HashMap<String, Movie>  imdb = new HashMap<>();
        Movie[] myfilms=Movie.exampleArray();
        imdb.put("First",myfilms[0]);
        imdb.put("Second",myfilms[1]);
        if(imdb.containsKey("First"))
            System.out.println("First is in map");
        imdb.put("First",myfilms[3]);




    }
}
