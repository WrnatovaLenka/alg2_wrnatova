package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;
import utils.BookkeepingInterface;




/**
 *
 * @author lenka.wrnatova
 */
public class Bookkeeping implements BookkeepingInterface{
    
    private ArrayList<Employee>employees = new ArrayList<>();
    private ArrayList<Position>positions = new ArrayList<>();
    private ArrayList<Attendance>attendance = new ArrayList<>();
    
    public void loadEmployees(String employeesFilepath) throws FileNotFoundException, IOException {
        File employeesFile = new File(employeesFilepath);
        Scanner inEmployees = new Scanner(employeesFile);
        while(inEmployees.hasNext()){
            
            String firstname = inEmployees.next();
            String surname = inEmployees.next();
            String position = inEmployees.next();
            Employee e = new Employee(firstname, surname, position);
            employees.add(e);
        }
       
    }
    
    
    public void loadPositions(String positionFilepath) throws FileNotFoundException, IOException {
        File positionFile = new File(positionFilepath);
        Scanner inPositions = new Scanner(positionFile);
        while(inPositions.hasNext()){
            
            String position = inPositions.next();
            int hourRate = inPositions.nextInt();
            Position p = new Position(position, hourRate);
            positions.add(p);
        }
       
    }
    
    public void loadAttendance(String attendanceFilepath) throws FileNotFoundException, IOException {
        File attendanceFile = new File(attendanceFilepath);
        Scanner inAttendance = new Scanner(attendanceFile);
        while(inAttendance.hasNext()){
            
            String firstname = inAttendance.next();
            String surname = inAttendance.next();
            String arrival = inAttendance.next();
            String leave = inAttendance.next();
            Attendance a = new Attendance(firstname, surname);
            a.setArrival(arrival);
            a.setLeave(leave);
            attendance.add(a);
        }
       
    }
    
    
@Override
    public void load(String employeesFilepath, String positionFilepath, String attendanceFilepath) throws FileNotFoundException, IOException {
        loadEmployees("data" + File.separator + employeesFilepath);
        loadPositions("data" + File.separator + positionFilepath);
        loadAttendance("data" + File.separator + attendanceFilepath);
        setHoursWorkedToEmployees();
        setSalariesToEmployees();
    }
    
    
    
    private ArrayList findEmployeesAttendance(String surname){
        ArrayList<Attendance>attendanceSurname = new ArrayList<>();
        for (Attendance attendance : attendance) {
            if(attendance.getSurname().equalsIgnoreCase(surname)){
                attendanceSurname.add(attendance);
            }
            
        }
        return attendanceSurname;
//        throw new NoSuchElementException("Zaměstnanec " + surname + " nebyl nalezen.");
    }
    
    
    
    public void  setHoursWorkedToEmployees(){
        long hoursWorked;
        double hoursWorkedDouble;
        for (Employee employee : employees) {
            hoursWorked = 0;
            ArrayList<Attendance>attendanceSurname = findEmployeesAttendance(employee.getSurname());
            for (Attendance attendance1 : attendanceSurname) {
               hoursWorked += attendance1.getLeave().toNanoOfDay() - attendance1.getArrival().toNanoOfDay();
            }
            hoursWorkedDouble = hoursWorked / 1000000;
            hoursWorkedDouble /= 3600000;
            employee.setHoursWorked(hoursWorkedDouble);
        }
    }
    
    private Position findPosition(String position){
        for (Position position1 : positions) {
            if(position1.getPosition().equalsIgnoreCase(position)){
                return position1;
            }
            
        }
    throw new NoSuchElementException("Pozice " + position + " nebyla nalezena.");
    }
    
    public void  setSalariesToEmployees(){
        double salary;
        for (Employee employee : employees) {
            salary = employee.getHoursWorked() * findPosition(employee.getPosition()).getHourRate();
            employee.setSalary(salary);
        }
    }


    @Override
    public void printRevenues() {
        System.out.println("tady se budou vypisovat prijmy");
    }

    @Override
    public void printExpenses() {
        System.out.println("tady se budou vypisovat vydaje");
    }

    @Override
    public void doBookkeeping() {
        System.out.println("timhle se vytvori ucetnictvi .txt");
    }

    
    
    @Override
    public String getSalaries() {
        StringBuilder sb = new StringBuilder("");
        
        for (Employee employee : employees) {
            sb.append(String.format("%10s %10s %.2f%3s%n", employee.getFirstname(),employee.getSurname(), employee.getSalary(), " Kč"));
            
        }
        return sb.toString();
    }

    @Override
    public void saveSalaries(String salariesFilepath) throws IOException {
        Writer w = null;
        if(salariesFilepath.endsWith(".txt")){
            w = new TextWriter();
        }else if(salariesFilepath.endsWith(".dat")){
            w = new BinaryWriter();
        }else{
            throw new IllegalArgumentException("Takovou koncovku nepodporujeme.");
        }
        w.saveResults(salariesFilepath, employees);
    }
    
}
