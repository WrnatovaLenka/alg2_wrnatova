package cz.tul.alp2.nshape;

/**
 *
 * @author lenka.wrnatova
 */
public class Point {

    private double x;
    private double y;
    private double distance;

    
    public Point() {
        this.x = 0;
        this.y = 0;
        distance = distanceFromOrigin();
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        distance = distanceFromOrigin();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    /**
     * Metoda zjisti vzdalenost bodu od pocatku
     * @param point bod, jehoz vzdalenost od pocatku chci zjistit
     * @return vraci vzdalenost od pocatku
     */
    private double distanceFromOrigin() {
        return Math.hypot(this.getX(), this.getY());
//        return this.distanceFromPoint(new Point(0,0));
    }

    /**
     * Metoda zjisti vzdalenost dvou bodu - bodu, na ktery volame tuto metodu a bodu z parametru
     * @param point druhy bod
     * @return vraci vzdalenost techto bodu
     */
    public double distanceFromPoint(Point point) {
        return Math.sqrt(Math.pow(point.getX() - this.x, 2) + Math.pow(point.getY() - this.y, 2));
    }

    /**
     * Metoda zjisti vzdalenost dvou bodu, ktere jsou predany v parametru
     * @param point1 prvni bod
     * @param point2 druhy bod
     * @return vraci vzdalenost techto bodu
     */
    public static double distanceOfTwoPoints(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }

}
