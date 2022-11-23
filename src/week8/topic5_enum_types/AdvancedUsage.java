package week8.topic5_enum_types;

/**
 *  Show advanced usage, singleton model (use case Country)
 *  enum types as anonymous inner classes
 */
public class AdvancedUsage {


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

    }

}
