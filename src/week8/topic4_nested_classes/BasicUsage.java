package week8.topic4_nested_classes;

import java.util.Comparator;

/**
 * Topic 4: enum types. Week 8 demo:
 *
 * Understand the four types of nested classes, each with demo example and use case example
 *
 * 1. static nested (use case Comparators)
 * 2. inner classes (use case Iterators)
 * 3. local classes (use case local Comparator)
 * 4. Anonymous classes (use case anon Comparator, anon ActionListener)
 */
public class BasicUsage {
    String myName = "Basic Usage";

    /**
     * Example of a static nested class
     */
    public static class StaticNested{
        int foo;
        double bah;
        public StaticNested(){
            foo=10;
            bah=3.333;
        }
        public StaticNested(int f, double b){
            foo=f;
            bah=b;
        }
    }
    /**
     * Example of an inner class
     */
    public class InnerClass{
        String name="Fred";
        double x=33;
        public String toString(){
            return name+","+x+" Outer class attribute ="+myName;
        }
    }
    /**
     * Example of a local class syntax. Local classes are classes that are defined in a block of code, usually a function.
     */
    public static void localClassFunction(){
        class MyContainer{
            int x;
            int y;
        }
        MyContainer first = new MyContainer();
        first.x=10;
        MyContainer second = new MyContainer();



    }

    /**
     * Example of an anonymous class. Anonymous classes implement an interface, often as a Functor, for a single use object.
     */
    public static void anonymousClassFunction(){
        Comparator<StaticNested> cmp1 = new Comparator<StaticNested>() {
            @Override
            public int compare(StaticNested o1, StaticNested o2) {
                return o1.foo-o2.foo;
            }
        };


    }


    public static void main(String[] args) {
        BasicUsage blah = new BasicUsage();
        BasicUsage.StaticNested meh = new BasicUsage.StaticNested();
        BasicUsage.InnerClass huh = blah.new InnerClass();
        System.out.println(huh);
        blah.myName=" HELLO!!";
        System.out.println(huh);





    }

}
