package week7.topic1_interfaces;

import java.util.ArrayList;

/**
 * Demoing the usefulness of passing references to interfaces
 */
public class ShapeProcessor {

    /**
     * Class method to find the shape with the biggest area
     *
     * @param shape1: Shape
     * @param shape2: Shape
     * @return the shape with the biggest area
     */
    Shape biggestAreaShape(Shape shape1, Shape shape2){
        if(shape1.area()>shape2.area())
            return shape1;
        return shape2;
    }

    /**
     *
     * @param myShapes: array of Shape Objects
     * @return
     */
    double areaSum(Shape[] myShapes){
        double sum=0;
        for(int i=0;i< myShapes.length;i++)
            sum+=myShapes[i].area();
        return sum;
    }


    /**
     * Static method to extract shapes with a Perimeter above the threshold
     * @param shapes array of shapes
     * @param threshold
     * @return
     */
    static ArrayList<Shape> bigPerimeterShapes(Shape[] shapes, double threshold){
        ArrayList<Shape> a= new ArrayList<>();
        for(Shape s:shapes)
            if(s.perimeter()>threshold)
                a.add(s);
        return a;
    }

    public static void main(String[] args) {

    }

}
