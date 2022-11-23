package week7.topic1_interfaces;

public class Square implements Shape{
    double length;
    public Square(double l){
        length=l;
    }
    @Override
    public double area() {
        return length*length;
    }

    @Override
    public double perimeter() {
        return 4*length;
    }
}
