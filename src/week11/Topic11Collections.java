package week11;

import java.util.*;

public class Topic11Collections {

    public static void main(String[] args) {
//Collections:
// 1. Lists (ArrayList, LinkedList)
        List<String> myList;
//AbstractList
//        List<String> myL2 = new MyList<>();
//        List<String> myL2 = new SortedList<>();

// Use cases for lists: processing item

// 2. Sets (HashSet, TreeSet)
        HashSet<String> myHash = new HashSet<>();
        TreeSet<String> myTree = new TreeSet<>();

// 3. Queues:
        Queue<String> myQueue = new LinkedList<>();
        Queue<String> myPriorityQueue = new PriorityQueue<>();

    }
}
