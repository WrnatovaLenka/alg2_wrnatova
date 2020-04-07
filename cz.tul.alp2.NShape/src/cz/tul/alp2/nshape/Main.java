package cz.tul.alp2.nshape;

import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    /**
     * vyrobi bod se souradnicemi ze std vstupu
     *
     * @return vraci vytvoreny bod
     */
    private static Point makePoint() {
        double xCoordinate;
        double yCoordinate;
        System.out.println("Zadej x-souřadnici bodu");
        xCoordinate = sc.nextDouble();
        System.out.println("Zadej y-souřadnici bodu");
        yCoordinate = sc.nextDouble();
        Point point = new Point(xCoordinate, yCoordinate);
        return point;
    }

    /**
     * vyrobi n-uhelnik z bodu zadavanych na std vstup
     *
     * @param nOfPoints pocet bodu n-uhelniku
     * @return pole objektu Point
     */
    private static Point[] makeNShape(int nOfPoints) {
        Point[] points = new Point[nOfPoints];
        for (int i = 0; i < points.length; i++) {
            points[i] = makePoint();
        }
        return points;
    }

    /**
     * vypise pole bodu
     *
     * @param points pole bodu
     */
    private static void outputArrayPoint(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i].toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//pocet bodu/uhlu
        System.out.println("Zadejte pocet bodu/uhlu n-uhelniku nebo cislo mensi nez 1 pro ukonceni");
        int nOfPoints;
        int choice;

        while ((nOfPoints = sc.nextInt()) > 1) {
            //vytvoření NShape

            NShape nShape = new NShape(makeNShape(nOfPoints));
            do {

                System.out.println("Jakou úlohu chcete spustit?");
                System.out.println("0 - konec");
                System.out.println("1 - výpočet obvodu");
                System.out.println("2 - bod nejbližší k počátku");
                System.out.println("3 - bod nejvzdálenější od počátku");
                System.out.println("4 - nejbližší body");
                System.out.println("5 - nejvzdálenější body");
                System.out.println("6 - přidání bodu k n-uhelniku");
//                System.out.println("5 - ");
                choice = sc.nextInt();
                switch (choice) {
                    //konec
                    case 0:
                        break;

                    case 1:
                        System.out.println(nShape.perimeter());
                        break;

                    case 2:
                        System.out.println(nShape.nearestFromOrigin());
                        break;

                    case 3:
                        System.out.println(nShape.furthestFromOrigin());
                        break;

                    case 4:
                        outputArrayPoint(nShape.nearestPoints());
                        break;

                    case 5:
                        outputArrayPoint(nShape.furthestPoints());
                        break;

                    case 6:
                        Point newPoint = makePoint();
                        nShape.add(newPoint);
                        break;
                }
            } while (choice > 0);
            System.out.println("Zadejte pocet bodu/uhlu n-uhelniku nebo cislo mensi nez 1 pro ukonceni");
        }

    }

}
