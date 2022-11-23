package week8.nested_classes;

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
    public static class StaticNested{
        int foo;
        double bah;
        public StaticNested(){
            foo=10;
            bah=3.333;
        }
    }
    public class InnerClass{
        String name="Fred";
        double x=33;
        public String toString(){
            return name+","+x+" Outer class attribute ="+myName;
        }
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
