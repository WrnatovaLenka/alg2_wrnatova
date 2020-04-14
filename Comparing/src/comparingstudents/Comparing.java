package comparingstudents;

import static comparingstudents.MyComparing.print;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author lenka.wrnatova
 */
public class Comparing {
    public static void main(String[] args) {
         Student[] students = Datasource.loadDataAsArray();
        print(students);
        System.out.println("Sort by number");
        //sort(students);
        Arrays.sort(students);//students musi byt typove kompatibilni s interface Comparable
        print(students);
        
        List<Student> students1 = Datasource.loadDataAsList();
        print(students1);
        System.out.println("Sort by number");
        Collections.sort(students1);
        print(students1);
    }
}