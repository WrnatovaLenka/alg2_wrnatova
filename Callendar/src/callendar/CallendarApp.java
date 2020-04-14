package callendar;

import static callendar.Callendar.printCallendar;
import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class CallendarApp {
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        do{
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 0 :
                    break;
                case 1 :
                    displayCallendar();
                    break;
            }
           
        }while(choice>0);
    }

    private static void displayMenu() {
        System.out.println("Zadejte volbu:");
        System.out.println("1 - zobrazit kalendar");
        System.out.println("0 - konec");
    }

    private static void displayCallendar() {
        int month, year;
        System.out.println("Zadejte mesic");
        month = sc.nextInt();
        System.out.println("Zadejte rok");
        year = sc.nextInt();
        printCallendar(month, year);
    }
    
}
