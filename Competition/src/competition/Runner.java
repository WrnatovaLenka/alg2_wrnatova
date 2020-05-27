package competition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lenka.wrnatova
 */
public class Runner implements Comparable{
    private int number;
    private String firstname;
    private String lasttname;
    private LocalTime startTime;
    private LocalTime finishTime;
    public static DateTimeFormatter dtfstart = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static DateTimeFormatter dtffinish = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(int number, String firstname, String lasttname) {
        this.number = number;
        this.firstname = firstname;
        this.lasttname = lasttname;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLasttname() {
        return lasttname;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }
    
    public String getStartTimeString(){
        return startTime.format(dtfstart);
    }
    
    public String getFinishTimeString(){
        return finishTime.format(dtffinish);
    }
     
    public LocalTime runningTime(){
       return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }

//    @Override
//    public String toString() {
//        return "Runner{" + "number=" + number + ", firstname=" + firstname + ", lasttname=" + lasttname + 
//                ", startTime=" + getStartTimeString() + ", finishTime=" + getFinishTimeString() + '}';
//    }
    
     @Override
    public String toString() {
        return String.format("%-4d%-10s%-10s%-15s%-15s%-15s",number,firstname,lasttname,getStartTimeString(),getFinishTimeString(),runningTime().format(dtffinish));
    }

   

    void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime, dtfstart);
    }
    
    void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime, dtffinish);
    }

    @Override
    public int compareTo(Object o) {
        return this.runningTime().compareTo(((Runner)o).runningTime());
    }

    public static void main(String[] args) {
        Runner r = new Runner(101, "Alice", "Mala");
        r.setStartTime("09:00:00");
        r.setFinishTime("10:20:12:000");
        System.out.println(r);
    }
}
