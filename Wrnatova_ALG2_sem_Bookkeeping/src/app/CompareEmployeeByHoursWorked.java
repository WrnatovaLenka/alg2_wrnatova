package app;

import utils.ComparatorInterface;

/**
 *
 * @author lenka.wrnatova
 */
public class CompareEmployeeByHoursWorked  implements ComparatorInterface{

    /**
     * Metoda porovnava zamestnance podle odpracovanych hodin
     * @param o1 prvni zsamestnanec
     * @param o2 druhy zamestnanec
     * @return 
     */
    @Override
    public boolean bigger(Object o1, Object o2) {
        return ((Employee)o1).getHoursWorked()< ((Employee)o2).getHoursWorked();
    }
    
}
