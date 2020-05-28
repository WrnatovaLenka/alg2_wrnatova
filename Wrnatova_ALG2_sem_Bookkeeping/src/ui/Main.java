package ui;

import app.Bookkeeping;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import utils.BookkeepingInterface;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BookkeepingInterface bki = new Bookkeeping();

        int volba;
        printMenu();

        while ((volba = sc.nextInt()) != 0) {

            switch (volba) {
                case 1:
                    System.out.println("Zadejte název souboru se zaměstnanci, hodinové sazby a docházku");
                    //employees.txt hourRate.txt attendance.txt
                    try {
                        loadEmployeesFromFiles(bki);
                        System.out.println(bki.getSalaries());
                        outputFile(bki);
                    } catch (IOException e) {
                        System.out.println("Chyba pri cteni a zapisu");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }
                    bki.clearData();
                    printMenu();
                    break;

                case 2:
                    System.out.println("Zadejte název souboru se zaměstnanci, hodinové sazby a docházku");
                    //employees.txt hourRate.txt attendance.txt

                    try {
                        loadEmployeesFromFiles(bki);
                        System.out.println(bki.getSalaries());
                        outputFile(bki);
                        System.out.println("Zadejte příjemce emailu");
                        //lennyw.school@gmail.com
                        String recipient = sc.next();
                        bki.sendMail(recipient);
                    } catch (IOException e) {
                        System.out.println("Chyba pri cteni a zapisu");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }

                    bki.clearData();
                    printMenu();
                    break;

                case 3:
                    System.out.println("Zadejte název souboru se zaměstnanci, hodinové sazby a docházku");
                    //employees.txt hourRate.txt attendance.txt

                    try {
                        loadEmployeesFromFiles(bki);
                    } catch (IOException e) {
                        System.out.println("Chyba pri cteni a zapisu");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println(bki.employeeOfTheMonth());
                    printMenu();
                    bki.clearData();
                    break;

                default:
                    System.out.println("Chybná volba");
                    break;
            }

        }
    }

    /**
     * Metoda vypise menu pro bookkeeping.
     */
    public static void printMenu() {
        System.out.println("Kterou úlohu si přejete provést?");
        System.out.println("1 - výpis výplat");
        System.out.println("2 - vytvořit výplaty a poslat email");
        System.out.println("3 - zaměstnacec měsíce");
        System.out.println("0 - konec programu");
    }

    /**
     * Metoda se dokola pta na nazvy souboru, dokud vsechny neexistuji
     *
     * @param bki BookkeepingInterface
     * @throws IOException
     */
    public static void loadEmployeesFromFiles(BookkeepingInterface bki) throws IOException {
        while (true) {
            try {
                String employeesFile = sc.next();
                String positionsFile = sc.next();
                String attendanceFile = sc.next();
                bki.load(employeesFile, positionsFile, attendanceFile);
                break;
            } catch (FileNotFoundException e) {
                bki.clearData();
                System.out.println("Zadany spatny soubor. Zadej znovu.");
            }
        }

    }

    /**
     * Metoda pro zapisovani do vystupniho souboru
     *
     * @param bki BookkeepingInterface
     * @throws IOException
     */
    public static void outputFile(BookkeepingInterface bki) throws IOException {
        System.out.println("Zadej nazev vystupniho souboru");
        String salariesFile = sc.next();
        bki.saveSalaries(salariesFile);
        System.out.println("Výplaty byly zapsány do souboru " + salariesFile);
    }

}
