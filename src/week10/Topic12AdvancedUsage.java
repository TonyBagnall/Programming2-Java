package week10;

public class Topic12AdvancedUsage<E> {
/*
1. Writing simple generic data structures: See pair class
3. Bounded type parameters
4. Generic methods
5. Wildcards: loosening restrictions
 */
    Foo<Integer> myFoo;
    Bar<Integer> myBar;
    public static void main(String[] args) {

//        1. Writing simple generic data structures: See pair class

        Wrapper<String> x = new Wrapper<>();
        x.set("Hello");
        String str = x.get();
        Wrapper<Integer> y = new Wrapper<>();
        Pair<Integer, int[]> intArray = new Pair<>(10, new int[3]);
        Pair<Double, int[]> intArray2= new Pair<>(10.0, new int[3]);;
//        intArray = intArray2;
        Pair<?, int[]> myInt = intArray2;

        myInt = intArray2;
        // TYPE SAFETY!!!        y.set("33");
//        String s2 = y.get();
        Topic12AdvancedUsage<String> adv = new Topic12AdvancedUsage<>();
        Bar<String> b = new Bar<>();
        Topic12AdvancedUsage.Foo f = adv.new Foo<>();

    }
    //Inner class: generics match
    public class Foo<E>{
        E bob;
    }
    //Static inner class: generics match
    public static class Bar<E>{
        E bob;
    }

}
