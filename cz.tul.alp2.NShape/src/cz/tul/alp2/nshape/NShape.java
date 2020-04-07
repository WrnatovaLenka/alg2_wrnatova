package cz.tul.alp2.nshape;


import static cz.tul.alp2.nshape.Point.distanceOfTwoPoints;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lenka.wrnatova
 */
public class NShape {

    //data
    private ArrayList<Point> points = new ArrayList();

    //constructors
    //default prazdny constructor
    public NShape() {
    }

    //TODO
    //constructory, ktere dokazi sebrat arraylist nebo sadu bodu
    public NShape(Point[] points) {
        this.points.addAll(Arrays.asList(points));
    }

    //TODO
    public NShape(ArrayList<Point> points) {
        ArrayList<Point> newPoints = (ArrayList<Point>) points.clone();
        this.points.addAll(newPoints);
    }

    //prida bod k n-uhelniku
    public void add(Point p) {
        points.add(p);
    }

    //vytvarime za uzivatele objekt bod
    public void add(double x, double y) {
        points.add(new Point(x, y));
    }

    //TODO prochazeni pole pomoci indexu
    public double perimeter() {
        double perim = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            perim += Point.distanceOfTwoPoints(points.get(i), points.get(i + 1));
        }
        perim += Point.distanceOfTwoPoints(points.get(0), points.get(points.size() - 1));
        return perim;
    }

    //TODO vrati bod s nejkratsi vzdalenosti od pocatku
    public Point nearestFromOrigin() {
        double min = Double.MAX_VALUE;
        Point nearest = null; //inicializace objektu
        for (Point p : points) {
            if (p.getDistance() < min) {
                min = p.getDistance();
                nearest = p;
            }
        }
        return nearest;
    }

    //TODO vrati bod s nejdelsi vzdalenosti od pocatku
    public Point furthestFromOrigin() {
        double max = Double.MIN_VALUE;
        Point furthest = null; //inicializace objektu
        for (Point p : points) {
            if (p.getDistance() > max) {
                max = p.getDistance();
                furthest = p;
            }
        }
        return furthest;
    }

    //TODO vrati nejkratsi vzdalenost mezi body
    public Point[] nearestPoints() {
        Point[] nearest = new Point[2];
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i != j) {
                    if (distanceOfTwoPoints(points.get(i), points.get(j)) < min) {
                        min = distanceOfTwoPoints(points.get(i), points.get(j));
                        nearest[0] = points.get(i);
                        nearest[1] = points.get(j);
                    }
                }
            }

        }
        return nearest;
    }

    //TODO vrati nejdelsi vzdalenost mezi body
    public Point[] furthestPoints() {
        Point[] furthest = new Point[2];
        double max = Double.MIN_VALUE;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i != j) {
                    if (distanceOfTwoPoints(points.get(i), points.get(j)) > max) {
                        max = distanceOfTwoPoints(points.get(i), points.get(j));
                        furthest[0] = points.get(i);
                        furthest[1] = points.get(j);
                    }
                }
            }

        }
        return furthest;
    }

}
