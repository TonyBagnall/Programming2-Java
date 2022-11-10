package week7.interfaces;

public class Circle implements Shape{

    double radius;
    public Circle(){
        radius=0;
    }
    public Circle(double r){
        radius=r;
    }
    public void setRadius(double r){
        radius = r;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
