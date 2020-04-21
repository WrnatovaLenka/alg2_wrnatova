package comparingstudents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author lenka.wrnatova
 */
public class Student implements CompareInterface, Comparable {
    //data
    private String firstName;
    private String lastName;
    private int studentNumber;
    private ArrayList<Integer> grades;
    private double averageGrade;

    //konstruktor
    public Student(String firstName, String lastName, int studentNumber) {
        this.grades = new ArrayList(0);
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        countAverage();
    }
    
    public Student(String firstName, String lastName, int studentNumber, ArrayList grades) {
        this.grades = grades;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        countAverage();
    }
    
    public Student(String firstName, String lastName, int studentNumber, int[] newGrades) {
        this.grades = new ArrayList(newGrades.length);
        for (int i = 0; i < newGrades.length; i++) {
            grades.add(i, newGrades[i]);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        countAverage();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
    
    

//    @Override
//    public String toString() {
//        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", studentNumber=" + studentNumber + ", grades=" + this.printGrades() + ", averageGrade=" + averageGrade + '}';
//    }

    
    @Override
    public String toString() {
        return String.format("%10s %10s %5d %.2f %20s", firstName, lastName, studentNumber, averageGrade, this.printGrades());
    }

    public boolean isBigger(Student student) {
        return this.studentNumber > student.studentNumber;
    }

    @Override
    public boolean isBigger(CompareInterface o) {
        return this.studentNumber > ((Student)o).studentNumber;
    }

    @Override
    public int compareTo(Object o) {
        return this.studentNumber - ((Student)o).studentNumber;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.firstName);
        hash = 29 * hash + Objects.hashCode(this.lastName);
        hash = 29 * hash + this.studentNumber;
        return hash;
    }
    
    private void countAverage(){
        double sumGrade = 0;
        double averageGrade;
        for (int grade : this.grades) {
            sumGrade += grade;
        }
        this.averageGrade = sumGrade/grades.size();
    }
    
    private void addGrade(int grade){
        this.grades.add(grade);
        countAverage();
    }
    
    private void changeGrade(int grade, int position){
        this.grades.add(position, grade);
        countAverage();
    }
    
    private String printGrades(){
        String gradesString = "[";
        for (int i = 0; i < this.grades.size()-1; i++) {
            gradesString += grades.get(i);
            gradesString += ", ";
        }
        gradesString += grades.get(grades.size()-1);
        gradesString += "]";
//        for (Integer grade : this.grades) {
//            gradesString += grade;
//            gradesString += ", ";
//        }
//        gradesString += "]";
        return gradesString;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.studentNumber != other.studentNumber) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
//    public static void main(String[] args) {
////        ArrayList<Integer> znamky = new ArrayList(4);
////        znamky.add(4);
////        znamky.add(1);
////        znamky.add(1);
////        znamky.add(2);
////        Student s1 = new Student("Karel", "Novak", 123);
//int[] znamky = {3, 1, 1, 2};
//        Student s1 = new Student("Karel", "Novak", 123, znamky);
//        System.out.println(s1);
//        s1.addGrade(2);
//        s1.addGrade(1);
//        s1.addGrade(1);
//        s1.addGrade(3);
//        s1.changeGrade(5, 1);
//        System.out.println(s1);
//    }
    
    
}
