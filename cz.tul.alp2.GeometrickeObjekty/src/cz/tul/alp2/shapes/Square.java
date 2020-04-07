package cz.tul.alp2.shapes;

/**
 *
 * @author lenka.wrnatova
 */
public class Square extends Rectangle{
    private double a;
    private double area;
    
    public Square(double a) {
        super(a, a);
        this.a = a;
        this.area = super.getArea();
    }

       @Override
    public String toString() {
        return "Square{" + "a=" + a + '}';
    }
    
//    public static void main(String[] args) {
//        Square s1 = new Square(3);
//        System.out.println(s1);
//        System.out.println(s1.computeArea());
//    }
}
