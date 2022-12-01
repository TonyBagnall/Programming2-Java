package Week9.topic9_reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class BasicUsage {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//Load a serialised object
        Object something = null;
        try{
            FileInputStream fis = new FileInputStream("temp.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            something =in.readObject();
            in.close();
        } catch (IOException e) {
            System.out.println(" ERROR: Cannot load a file temp.ser operation failed");
        }
        catch (ClassNotFoundException e){
            System.out.println(" Cast failed");
        }
        System.out.println(" Object loaded "+something);
        Class c= something.getClass();

        System.out.println(" something class  = "+c);
        System.out.println(" something is of type  = "+c.getName());
        System.out.println(" something short name  = "+c.getSimpleName());
        System.out.println(" descriptor  = "+c.descriptorString());

        Method m = c.getDeclaredMethods()[5];
        System.out.println(" First method = "+m);
        m.invoke(something);
        System.out.println(" Object loaded "+something);

    }

}
