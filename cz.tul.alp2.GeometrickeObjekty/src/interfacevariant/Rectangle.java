package interfacevariant;



/**
 *
 * @author lenka.wrnatova
 */

//nemenny immutable objekt
public class Rectangle implements ShapeInterface{
    //data
    private double a;
    private double b;
    private double area; //vypocitana

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = area();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    //neni ted potreba (computeArea)
    public double getArea() {
        return area;
    }
    
    @Override
    public double computeArea(){
        return area;
    }
    
    //private, protoze ji volam v konstruktoru
    private double area(){
        return a*b;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
//        return super.toString() + String.format(" a = %.2f, b = %.2f", a, b);
    }
    
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2,3);
        System.out.println(r1);
    }
}
