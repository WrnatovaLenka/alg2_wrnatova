package cz.tul.alp2.shapes;

/**
 *
 * @author lenka.wrnatova
 */
public class Circle extends Shape implements java.lang.Comparable{ //Circle je typove kompatibilni s Shape, Cirlr IS a Shape
    //data
    private double r;

    //udelali jsme ho private, budeme volat pres tovarni metody
    private Circle(double r) {
        this.r = r;
    }
    
    //nelze, protoze je stejneho typu, jako ten druhy konstruktor
//    public Circle(double d) {
//        this.r = d/2.0;
//    }
    
    //tovarni metoda - factory method
    public static Circle getInstanceD(double d){
       return new Circle(d/2.0);
    }
    
    public static Circle getInstanceR(double r){
       return new Circle(r);
    }

    public double getR() {
        return r;
    }

    @Override
    public String toString() {
//        return "Circle{" + "r=" + r + '}';
        return super.toString() + String.format(" r = %.2f", r);
    }
    
    //obsah
    @Override
    public double computeArea(){
       return Math.PI*r*r;
    }
    
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceR(4);
        System.out.println(c1);
//        System.out.println(c1.computeArea());
        System.out.println(c1.name);
        System.out.println(c1.getShapeName());
    }

    @Override
    public int compareTo(Object o) {
       return (int) (this.computeArea() - ((Shape)o).computeArea());
    }
    
    
}
