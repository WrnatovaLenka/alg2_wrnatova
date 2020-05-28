package app;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *Zapisovani do souboru
 * @author lenka.wrnatova
 */
public abstract class Writer {
    public static File dataDirectory = new File(System.getProperty("user.dir") + File.separator + "data");
    
    public abstract void saveResults(String employeesFilepath, List<Employee> employees) throws IOException;
}
