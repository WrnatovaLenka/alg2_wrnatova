package app;

/**
 *Trida reprezentujici zamestnance firmy.
 * @author lenka.wrnatova
 */
public class Employee{
    private String firstname;
    private String surname;
    private String position;
    private double hoursWorked = 0;
    private double salary;

    public Employee(String firstname, String surname, String position) {
        this.firstname = firstname;
        this.surname = surname;
        this.position = position;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getSalary() {
        return salary;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
