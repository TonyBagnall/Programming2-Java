package week7.topic1_interfaces;

import java.util.ArrayList;

/**
 * Example application that uses the ShapeProcessor
 */
public class ShapeApplication {

    public static Shape[] exampleShapes(){
        Shape[] s = new Shape[2];
        s[0] = new Circle(10);
        s[1] = new Square(5);
        return s;
    }

    public static void main(String[] args) {
        Shape[] myShapes = exampleShapes();
        ShapeProcessor sp = new ShapeProcessor();

        double area = sp.areaSum(myShapes);
        System.out.println(" Biggest area = "+area);
        Shape biggest = sp.biggestAreaShape(myShapes[0], myShapes[1]);
        System.out.println(" Biggest shape = "+biggest);
        ArrayList<Shape> ar= ShapeProcessor.bigPerimeterShapes(myShapes, 10);
        for( Shape s:ar)
            System.out.println(s);
    }
}
