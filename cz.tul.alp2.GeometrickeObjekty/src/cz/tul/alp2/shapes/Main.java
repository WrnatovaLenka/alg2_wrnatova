package cz.tul.alp2.shapes;

import java.util.ArrayList;

/**
 *
 * @author lenka.wrnatova
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Circle c1 = Circle.getInstanceD(8);
        Rectangle r1 = new Rectangle(2, 3);
        Circle c2 = Circle.getInstanceR(2.6);

        System.out.println("1. varianta");
        double allArea1 = c1.computeArea() + c2.computeArea() + r1.getArea();
        System.out.println(allArea1);

        System.out.println("2. varianta");
        ArrayList shapes2 = new ArrayList(); //dynamicke pole objektu typu Object
        //muze obsahovat cokoliv co je typove kompatibilni s Object
        shapes2.add(c1);
        shapes2.add(r1);
        //shapes2.add(c2);
        shapes2.add(Circle.getInstanceR(2.6));

        double allArea2 = 0;
        for (int i = 0; i < shapes2.size(); i++) {
            if (shapes2.get(i) instanceof Circle) {
                allArea2 += ((Circle) shapes2.get(i)).computeArea();
            } else if (shapes2.get(i) instanceof Rectangle) {
                allArea2 += ((Rectangle) shapes2.get(i)).computeArea();
            }
        }
        System.out.println(allArea2);
        
        System.out.println("3. varianta");
        ArrayList<Shape> shapes3 = new ArrayList<>(); //dynamicke pole objektu typu Shape
        //muze obsahovat cokoliv co je typove kompatibilni s Shape (potomci Shape)
        shapes3.add(c1);
        shapes3.add(r1);
        shapes3.add(c2);
        double allArea3 = 0;
        for(Shape shape : shapes3){
            allArea3 += shape.computeArea(); //polymorfismus
        }
        System.out.println(allArea3);
        
    }

}
