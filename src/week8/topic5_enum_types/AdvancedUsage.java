package week8.topic5_enum_types;

/**
 *  Show advanced usage, singleton model (use case Country)
 *  enum types as anonymous inner classes
 */
public class AdvancedUsage {

    enum Colour{ RED, GREEN, BLUE};

    enum Country{ENGLAND(10,5,33.0), SCOTLAND(1,6,11.0), FRANCE(1,2,22.0);

        Country(double p, double l, double g){
            population=p;
            landmass=l;
            gdp=g;
        }
        double population;
        double landmass;
        double gdp;


    }







    enum Grade2 {
        FIRST(70), TWO_ONE(60), TWO_TWO(50), THIRD(40), FAIL(0);
        final int boundary;

        Grade2(int x) {
            boundary = x;
        }
    }

    static public abstract class Grade{
        final int boundary;
        private Grade(int b){ boundary=b;}
        public static final Grade FIRST = new Grade(70){};
        public static final Grade TWO_ONE = new Grade(60){};
        public static final Grade TWO_TWO = new Grade(50){};
        public static final Grade THIRD = new Grade(40){};
        public static final Grade FAIL = new Grade(0){};

    }

    public static void main(String[] args) {
        Country eng = Country.ENGLAND;
        System.out.println(" population = "+eng.population);
        eng.population = 70000000;
        temp();
    }
    static void temp(){
        Country e = Country.ENGLAND;
        System.out.println(" population = "+e.population);

    }
}
