package competition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Competition c = new Competition();
        System.out.println("Zadej nazvy vstupnich souboru");
        try{
            while (true) {
                try {
                    String startFile = sc.next();
                    String finishFile = sc.next();
                    c.load(startFile, finishFile);
                    break;
                } catch (FileNotFoundException e) {
                    System.out.println("Zadany spatny soubor. Zadej znovu.");
                }
            }
            System.out.println(c.getResults());
            System.out.println("Zadej nazev vystupniho souboru");
            String resultFile = sc.next();
            c.saveResults(resultFile);
        }catch(IOException e){
            System.out.println("Chyba pri cteni a zapisu");
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

}
