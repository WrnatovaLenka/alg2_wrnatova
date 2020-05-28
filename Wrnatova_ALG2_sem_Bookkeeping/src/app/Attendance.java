package app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *Trida predstavuje dochazku zamestnancu
 * @author lenka.wrnatova
 */
public class Attendance {
    private String firstname;
    private String surname;
    private LocalTime arrival;
    private LocalTime leave;
    public static DateTimeFormatter dtfattendance = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Attendance(String firstname, String surname, LocalTime arrival, LocalTime leave) {
        this.firstname = firstname;
        this.surname = surname;
        this.arrival = arrival;
        this.leave = leave;
    }

    public Attendance(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public LocalTime getArrival() {
        return arrival;
    }

    public LocalTime getLeave() {
        return leave;
    }

    void setArrival(String arrival) {
        this.arrival = LocalTime.parse(arrival);
    }
    
    void setLeave(String leave) {
        this.leave = LocalTime.parse(leave);
    }
    
}
