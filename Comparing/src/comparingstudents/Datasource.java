package comparingstudents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lenka.wrnatova
 */
public class Datasource {
    static int[] znamkyAlice = {1, 1, 2, 1, 1};
    static int[] znamkyBob = {5, 4, 4};
    static int[] znamkyCyril = {2, 3, 2, 1, 1};
    private static Student[] data = {
      new Student("Alice","Mala",345, znamkyAlice),
      new Student("Bob","Velky",123, znamkyBob),
      new Student("Cyril","Stredny",567, znamkyCyril)
    };
    
    public static Student[] loadDataAsArray(){
        return Arrays.copyOf(data, data.length);
    }
    
    public static List<Student> loadDataAsList(){
        return Arrays.asList(data);
//        ArrayList<Student> students = new ArrayList<>();
//        students.addAll(Arrays.asList(data));
    }
}
