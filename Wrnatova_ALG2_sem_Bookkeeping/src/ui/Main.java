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
    public static void main(String[] args) {
        BookkeepingInterface bki = new Bookkeeping();

        int volba;
        System.out.println("Kterou úlohu si přejete provést?");
        System.out.println("1 - výpis výplat");
        System.out.println("2 - výpis příjmů z prodeje");
        System.out.println("3 - výpis výdajů za nákup zboží");
        System.out.println("4 - provést účetnictví");
        System.out.println("0 - konec programu");

        while ((volba = sc.nextInt()) != 0) {
            

            switch (volba) {
                case 1:
                    System.out.println("Zadejte název souboru se zaměstnanci, hodinové sazby a docházku");
                    try {
                        while (true) {
                            try {
                                String employeesFile = sc.next();
                                String positionsFile = sc.next();
                                String attendanceFile = sc.next();
                                bki.load(employeesFile, positionsFile, attendanceFile);
                                break;
                            } catch (FileNotFoundException e) {
                                System.out.println("Zadany spatny soubor. Zadej znovu.");
                            }
                        }
                        System.out.println(bki.getSalaries());
                        //TODO suma výplat
                        System.out.println("Zadej nazev vystupniho souboru");
                        String salariesFile = sc.next();
                        bki.saveSalaries(salariesFile);
                        System.out.println("Výplaty byly zapsány do souboru " + salariesFile);
                    } catch (IOException e) {
                        System.out.println("Chyba pri cteni a zapisu");
                    } catch (NoSuchElementException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Kterou úlohu si přejete provést?");
            System.out.println("1 - výpis výplat");
            System.out.println("2 - výpis příjmů z prodeje");
            System.out.println("3 - výpis výdajů za nákup zboží");
            System.out.println("4 - provést účetnictví");
            System.out.println("0 - konec programu");
                    break;
                    
                case 2:
                    bki.printRevenues();
                    break;
                case 3:
                    bki.printExpenses();
                    break;
                case 4:
                    bki.doBookkeeping();
                    break;
//                case 0:
//                    System.out.println("Konec programu");
//                    break;
                default:
                    System.out.println("Chybná volba");
                    break;
            }

        }
    }

}
