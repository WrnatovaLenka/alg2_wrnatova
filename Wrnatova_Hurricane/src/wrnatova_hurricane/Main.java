package wrnatova_hurricane;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HurricaneInterface hI = new HuricaneApp();
        Scanner sc = new Scanner(System.in);
        int volba, yearStart, yearEnd;
        String hurricane;

        try {
            hI.load();
        } catch (Exception e) {
            System.out.println("Neplatny soubor");
        }

        System.out.println("1 - Vypis informaci o hurikanech v danem obdobi");
        System.out.println("2 - Informace o hurikanu");
        System.out.println("3 - Hurikany setridene podle rychlosti");
        System.out.println("0 - Konec");

        while ((volba = sc.nextInt()) != 0) {

            switch (volba) {
                case 1:
                    System.out.println("Vypis informaci o hurikanech v danem obdobi");
                    System.out.println("Pocatecni rok");
                    yearStart = sc.nextInt();
                    System.out.println("Koncovy rok");
                    yearEnd = sc.nextInt();
                    System.out.println(hI.hurricanesFromTo(yearStart, yearEnd));

                    System.out.println("1 - Vypis informaci o hurikanech v danem obdobi");
                    System.out.println("2 - Informace o hurikanu");
                    System.out.println("3 - Hurikany setridene podle rychlosti");
                    System.out.println("0 - Konec");

                    break;
                case 2:
                    System.out.println("Zadejte nazev hurikanu");
                    hurricane = sc.next();
                    System.out.println(hI.hurricaneByName(hurricane));

                    System.out.println("1 - Vypis informaci o hurikanech v danem obdobi");
                    System.out.println("2 - Informace o hurikanu");
                    System.out.println("3 - Hurikany setridene podle rychlosti");
                    System.out.println("0 - Konec");

                    break;
                case 3:
                    System.out.println("Hurikany setridene podle rychlosti");
                    System.out.println(hI.hurricaneInfoBySpeed());

                    System.out.println("1 - Vypis informaci o hurikanech v danem obdobi");
                    System.out.println("2 - Informace o hurikanu");
                    System.out.println("3 - Hurikany setridene podle rychlosti");
                    System.out.println("0 - Konec");

                    break;
            }

        }

    }

}
