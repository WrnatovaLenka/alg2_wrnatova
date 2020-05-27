package edok;

/*! \class Square
    \brief Trida predstavuje objekt ctverec.
*/
public class Square extends Rectangle{
    private double a;
    private double area;

    public Square(double a, double b) {
        super(a, a);
        this.a = a;
        this.area = GeometricLibrary.computeRectangleArea(a, a);
    }

    @Override
    public String toString() {
        return "Square{" + "a=" + a + ", area=" + area + '}';
    }

}
