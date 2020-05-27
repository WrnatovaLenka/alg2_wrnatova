package edok;

/*! \class Rectangle
    \brief Trida predstavuje objekt obdelnik.
*/
public class Rectangle {
    private double a;
    private double b;
    private double area;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
        this.area = GeometricLibrary.computeRectangleArea(a, b);
    }

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + ", area=" + area + '}';
    }
    
    

    
}
