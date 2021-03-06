package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author lenka.wrnatova
 */
public class TextWriter extends Writer{
    
    @Override
    public void saveResults(String employeesFilepath, List<Employee> employees) throws IOException{
        File resultFile = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + employeesFilepath);
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(System.getProperty("user.dir") + File.separator + "data" + File.separator + employeesFilepath)))) {
            pw.println("Výplaty: ");
            for (Employee employee : employees) {
                pw.printf("%10s %10s %.2f%3s%n", employee.getFirstname(),employee.getSurname(), employee.getSalary(), " Kč");
            }
        }
    }
    
}
