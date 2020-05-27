package edok;

/*! \class EDOK
    \brief Main class pro testovani funkcnosti.
*/
public class EDOK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2,3);
        Square s1 = new Square(2,5);
        Cuboid cb1 = new Cuboid(2, 3, 4);
        Cube c1 = new Cube(2, 7, 10);
        
        System.out.println(r1);
        System.out.println(s1);
        System.out.println(cb1);
        System.out.println(c1);
    }
    
}
