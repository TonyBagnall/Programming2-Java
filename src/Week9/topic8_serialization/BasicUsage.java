package Week9.topic8_serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BasicUsage {


    public static void main(String[] args) {
        ArrayList<Integer> myList=new ArrayList<>();
        myList.add(33);
        myList.add(42);
        myList.add(10);
        System.out.println(myList);
        try{
            FileOutputStream fos = new FileOutputStream("temp.ser");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(myList);
            out.close();
            System.out.println("Array saved .....");
        }
        catch (IOException e) {
            System.out.println(" ERROR: Cannot write to the save file temp.ser operation failed");
        }
        Collections.sort(myList);
        System.out.println(myList);
        try{
            FileInputStream fis = new FileInputStream("temp.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            myList =(ArrayList<Integer>)in.readObject();
            in.close();
            System.out.println("Array loaded");
        } catch (IOException e) {
            System.out.println(" ERROR: Cannot load a file temp.ser operation failed");
        }
        catch (ClassNotFoundException e){
            System.out.println(" Cast to ArrayList failed");
        }
        System.out.println(myList);
}

}
