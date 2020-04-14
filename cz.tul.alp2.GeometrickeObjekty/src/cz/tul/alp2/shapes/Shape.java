package cz.tul.alp2.shapes;

/**
 *
 * @author lenka.wrnatova
 */
public abstract class Shape implements java.lang.Comparable{ //abstraktni trida
    //data
    protected String name = "Geometric object";
    
//    public double computeArea(){
//        return 0;
//    }
    
    
    
    public abstract double computeArea(); //abstraktni metoda nemusi mit telo
    
    public String getShapeName(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name + ": " + getShapeName();
    }
    
}
