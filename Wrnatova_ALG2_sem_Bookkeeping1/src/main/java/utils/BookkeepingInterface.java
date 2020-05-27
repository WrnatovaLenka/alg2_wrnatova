package utils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author lenka.wrnatova
 */
public interface BookkeepingInterface {
    
    public void load(String filePath, String filePath2, String filePath3)throws FileNotFoundException, IOException ;
    public void printRevenues();
    public void printExpenses();
    public void doBookkeeping();

    public String getSalaries();

    public void saveSalaries(String salariesFile) throws IOException;
    
}
