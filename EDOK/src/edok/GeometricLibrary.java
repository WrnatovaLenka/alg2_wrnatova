package edok;

/*! \class GeometricLibrary
    \brief Trida predstavuje knihovnu pro geometricke objekty.
*/
public class GeometricLibrary {
    
    /**
     * 
     * @param a strana a obdelniku
     * @param b strana b obdelniku
     * @return vraci vypocitanou plochu obdelniku
     */
    public static double computeRectangleArea (double a, double b){
        double area = a*b;
        return area;
    }
    
    /**
     * 
     * @param a strana a kvadru
     * @param b strana b kvadru
     * @param c strana c kvadru
     * @return vraci vypocitany objem
     */
    public static double computeCuboidVolume (double a, double b, double c){
        double volume = a*b*c;
        return volume;
    }
    
    /**
     * 
     * @param a strana a kvadru
     * @param b strana b kvadru
     * @param c strana c kvadru
     * @return vraci vypocitany povrch
     */
    public static double computeCuboidSurface (double a, double b, double c){
        double surface = 2*a*b+2*b*c+2*a*c;
        return surface;
    }
    
}
