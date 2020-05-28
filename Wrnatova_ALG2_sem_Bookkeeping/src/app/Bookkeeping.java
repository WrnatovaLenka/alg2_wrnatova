package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import utils.BookkeepingInterface;
import utils.ComparatorInterface;

/**
 * Logika pro ucetnictvi
 *
 * @author lenka.wrnatova
 */
public class Bookkeeping implements BookkeepingInterface {

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Position> positions = new ArrayList<>();
    private ArrayList<Attendance> attendance = new ArrayList<>();

    /*
    ***********************************
    **************LOADING**************
    ***********************************
    */
    
    /**
     * Metoda nacte zamestnance ze souboru a ulozi je do ArrayList
     *
     * @param employeesFilepath nazev souboru se zamestnanci
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadEmployees(String employeesFilepath) throws FileNotFoundException, IOException {
        File employeesFile = new File(employeesFilepath);
        Scanner inEmployees = new Scanner(employeesFile);
        while (inEmployees.hasNext()) {
            String firstname = inEmployees.next();
            String surname = inEmployees.next();
            String position = inEmployees.next();
            Employee e = new Employee(firstname, surname, position);
            employees.add(e);
        }
    }

    /**
     * Metoda nacte pozice ze souboru a ulozi je do ArrayList
     *
     * @param positionFilepath nazev souboru s pozicemi
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadPositions(String positionFilepath) throws FileNotFoundException, IOException {
        File positionFile = new File(positionFilepath);
        Scanner inPositions = new Scanner(positionFile);
        while (inPositions.hasNext()) {
            String position = inPositions.next();
            int hourRate = inPositions.nextInt();
            Position p = new Position(position, hourRate);
            positions.add(p);
        }
    }

    /**
     * Metoda nacte dochazku ze souboru a ulozi je do ArrayList
     *
     * @param attendanceFilepath nazev souboru s dochazkou
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void loadAttendance(String attendanceFilepath) throws FileNotFoundException, IOException {
        File attendanceFile = new File(attendanceFilepath);
        Scanner inAttendance = new Scanner(attendanceFile);
        while (inAttendance.hasNext()) {
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

    /**
     * Metoda nacte zamestnance, dochazku a pozice do ArrayListu a zamestnancum doplni odpracovane hodiny a platy
     * @param employeesFilepath nazev souboru se zamestnanci
     * @param positionFilepath nazev souboru s pozicemi
     * @param attendanceFilepath nazev souboru s dochazkou
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void load(String employeesFilepath, String positionFilepath, String attendanceFilepath) throws FileNotFoundException, IOException {
        loadEmployees("data" + File.separator + employeesFilepath);
        loadPositions("data" + File.separator + positionFilepath);
        loadAttendance("data" + File.separator + attendanceFilepath);
        setHoursWorkedToEmployees();
        setSalariesToEmployees();
    }

    /*
    ***********************************
    **************FINDING**************
    ***********************************
    */
    
    /**
     * Metoda najde vsechny zaznamy dochazky konkretniho zamestnance
     * @param surname prijimeni zamestnance
     * @return  vraci ArrayList s dochazkou
     */
    private ArrayList findEmployeesAttendance(String surname) {
        ArrayList<Attendance> attendanceSurname = new ArrayList<>();
        for (Attendance attendance : attendance) {
            if (attendance.getSurname().equalsIgnoreCase(surname)) {
                attendanceSurname.add(attendance);
            }

        }
        return attendanceSurname;
//        throw new NoSuchElementException("Zaměstnanec " + surname + " nebyl nalezen.");
    }
    
    /**
     * Metoda najde pozici podle jmena
     * @param position pracovni pozice kterou hledam
     * @return Vraci pozici(objekt) se zadanym jmenem
     */
    private Position findPosition(String position) {
        for (Position position1 : positions) {
            if (position1.getPosition().equalsIgnoreCase(position)) {
                return position1;
            }

        }
        throw new NoSuchElementException("Pozice " + position + " nebyla nalezena.");
    }

    /*
    ***********************************
    **************SETTING**************
    ***********************************
    */
    
    /**
     * Metoda spocita a priradi pocet odpracovanych hodin zamestnance
     */
    public void setHoursWorkedToEmployees() {
        long hoursWorked;
        double hoursWorkedDouble;
        for (Employee employee : employees) {
            hoursWorked = 0;
            ArrayList<Attendance> attendanceSurname = findEmployeesAttendance(employee.getSurname());
            for (Attendance attendance1 : attendanceSurname) {
                hoursWorked += attendance1.getLeave().toNanoOfDay() - attendance1.getArrival().toNanoOfDay();
            }
            hoursWorkedDouble = hoursWorked / 1000000;
            hoursWorkedDouble /= 3600000;
            employee.setHoursWorked(hoursWorkedDouble);
        }
    }

    /**
     * Metoda spocita a priradi zamestnancum vyplaty
     */
    public void setSalariesToEmployees() {
        double salary;
        for (Employee employee : employees) {
            salary = employee.getHoursWorked() * findPosition(employee.getPosition()).getHourRate();
            employee.setSalary(salary);
        }
    }

    /*
    ***********************************
    **************GETTING**************
    ***********************************
    */
    
    /**
     * Metoda sestavi seznam jmen zamestnancu a jejich vyplaty
     * @return  String zamestnancu s vyplatami
     */
    @Override
    public String getSalaries() {
        StringBuilder sb = new StringBuilder("");

        for (Employee employee : employees) {
            sb.append(String.format("%10s %10s %.2f%3s%n", employee.getFirstname(), employee.getSurname(), employee.getSalary(), " Kč"));

        }
        return sb.toString();
    }

    /**
     * Metoda sestavi seznam jmen zamestnancu a jejich odpracovane hodiny
     * @return String zamestnancu s odpracovanymi hodinami
     */
    public String getHoursWorked() {
        StringBuilder sb = new StringBuilder("");

        for (Employee employee : employees) {
            sb.append(String.format("%10s %10s %.2f%6s%n", employee.getFirstname(), employee.getSurname(), employee.getHoursWorked(), " hodin"));

        }
        return sb.toString();
    }
    
    /*
    ***********************************
    ***************OTHERS**************
    ***********************************
    */

    /**
     * Metoda setridi arrayList podle kriteria
     * @param arrayList list, ktery chci tridit
     * @param o kriterium pro trideni
     */
    public static void sort(ArrayList arrayList, ComparatorInterface o) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = 1; j < arrayList.size() - i; j++) {
                if (o.bigger(arrayList.get(j - 1), arrayList.get(j))) {
                    Object temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j - 1));
                    arrayList.set(j - 1, temp);
                }

            }

        }
    }
    
    /**
     * Metoda setridi zamestnance podle poctu odpracovanych hodin
     * @return seznam zamestnancu a jejich hodin
     */
    @Override
    public String employeeOfTheMonth() {
        sort(employees, new CompareEmployeeByHoursWorked());
        String result = getHoursWorked();
        return result;
    }
    
    /**
     * Metoda uklada vyplaty do souboru
     * @param salariesFilepath nazev souboru
     * @throws IOException 
     */
    @Override
    public void saveSalaries(String salariesFilepath) throws IOException {
        Writer w = null;
        if (salariesFilepath.endsWith(".txt")) {
            w = new TextWriter();
        } else if (salariesFilepath.endsWith(".dat")) {
            w = new BinaryWriter();
        } else {
            throw new IllegalArgumentException("Takovou koncovku nepodporujeme.");
        }
        w.saveResults(salariesFilepath, employees);
    }

    /**
     * Metoda pro odeslani emailu z lennyw.school@gmail.com
     * @param recepient
     * @throws Exception 
     */
    public void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        String myAccountEmail = "lennyw.school@gmail.com";
        //pri prezentaci zmen heslo
        String password = "*****";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message sent succesfully");
    }

    /**
     * Pripravi zpravu pro email
     * @param session
     * @param myAccountEmail email, ze ktereho se zprava odesila
     * @param recipient projemce emailu
     * @return vraci zpravu
     */
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("my first email");
            message.setText("hi there, \n look my email!");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Bookkeeping.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Metoda vyprazdni ArrayList zamestnancu, poztic a dochazky
     */
    public void clearData() {
        employees.clear();
        positions.clear();
        attendance.clear();
    }

    

    
}
