package week7.interfaces;

import java.util.ArrayList;

/**
 * Example application that uses the ShapeProcessor
 */
public class ShapeApplication {

    public static Shape[] exampleShapes(){
        return null;
    }

    public static void main(String[] args) {
        Shape[] myShapes = exampleShapes();
        ShapeProcessor sp = new ShapeProcessor();

        double area = sp.areaSum(myShapes);
        System.out.println(" Biggest area = "+area);
        Shape biggest = sp.biggestAreaShape(myShapes[0], myShapes[2]);
        System.out.println(" Biggest shape = "+biggest);
        ArrayList<Shape> ar= ShapeProcessor.bigPerimeterShapes(myShapes, 10);
        for( Shape s:ar)
            System.out.println(s);
    }
}
