package edok;

/*! \class Cube
    \brief Trida predstavuje objekt krychle.
*/
public class Cube extends Cuboid{
    private double a;
    private double volume;
    private double surface;

    @Override
    public String toString() {
        return "Cube{" + "a=" + a + ", volume=" + volume + ", surface=" + surface + '}';
    }

    public Cube(double a, double b, double c) {
        super(a, a, a);
        this.a = a;
        this.volume = GeometricLibrary.computeCuboidVolume(a, a, a);
        this.surface = GeometricLibrary.computeCuboidSurface(a, a, a);
    }
    
    
}
