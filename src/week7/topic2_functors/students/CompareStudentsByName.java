package week7.topic2_functors.students;

/**
 * Example of using the user defined interface CompareStudent
 */

public class CompareStudentsByName implements CompareStudent{
    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}
