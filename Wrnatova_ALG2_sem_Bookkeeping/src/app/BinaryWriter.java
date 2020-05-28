package app;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author lenka.wrnatova
 */
public class BinaryWriter extends Writer {
    
    /**
     * Metoda ulozi seznam zamestnancu a jejich vyplat do binarniho souboru
     * @param employeesFilepath nazev vystupniho souboru
     * @param employees seznam zamestnancu
     * @throws IOException 
     */
    @Override
    public void saveResults(String employeesFilepath, List<Employee> employees) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("data" + File.separator + employeesFilepath))){
            dos.writeUTF("Nove vysledky");
            int n = 1;
            for (Employee employee : employees) {
//                dos.writeInt(n);
                //dos.writeChar('.');
                dos.writeUTF(employee.getFirstname());
                int nChars = employee.getSurname().length();
                dos.writeInt(nChars);
                for (int i = 0; i < nChars; i++) {
                    dos.writeChar(employee.getSurname().charAt(i));
                }
                n++;
                dos.writeDouble(employee.getSalary());
            }
        }
    }
    
}
