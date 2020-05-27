package edok;

/*! \class Cuboid
    \brief Trida predstavuje objekt kvadr.
*/
public class Cuboid {
    private double a;
    private double b;
    private double c;
    private double volume;
    private double surface;

    public Cuboid(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.volume = GeometricLibrary.computeCuboidVolume(a, b, c);
        this.surface = GeometricLibrary.computeCuboidSurface(a, b, c);
    }

    @Override
    public String toString() {
        return "Cuboid{" + "a=" + a + ", b=" + b + ", c=" + c + ", volume=" + volume + ", surface=" + surface + '}';
    }
    
    
    
}
