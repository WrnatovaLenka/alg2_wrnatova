package cz.tul.alp2.shapes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class ShapeApp {
static Scanner sc = new Scanner(System.in);
static ArrayList<Shape> shapes = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        
        do{
        displayMenu();
        choice = readChoice();
        switch (choice){
            case 0 :
                break;
            case 1 :
                clearObjects();
                break;
            case 2 :  
                addSquare();
                break;
            case 3 :
                addRectangle();
                break;
            case 4 :    
                addCircle();
                break;
            case 5 :    
                printObjects();
                break;
            case 6 :    
                computeArea();
                break;
            case 7 :    
                findWithMaxArea();
                break;
        }
        
        }while (choice != 0);
    }
    
    public static void displayMenu(){
        System.out.println("");
        System.out.println("1. nova sada");
        System.out.println("2. pridej ctverec");
        System.out.println("3. pridej obdelnik");
        System.out.println("4. pridej kruh");
        System.out.println("5. vypis geometricke objekty");
        System.out.println("6. vypocti celkovou plochu");
        System.out.println("7. vypis objekt s nejvetsi plochou");
        System.out.println("0. konec programu");
        
    }
    
    private static int readChoice(){
        System.out.println("zadejte volbu");
        return sc.nextInt();
    }
    
    private static void addSquare(){
        Double a;
        System.out.println("zadejte delku hrany ctverce");
        a = sc.nextDouble();
        shapes.add(new Square(a));
        
    }
    
    private static void addRectangle(){
        Double a, b;
        System.out.println("zadejte delku hrany a");
        a = sc.nextDouble();
        System.out.println("zadejte delku hrany b");
        b = sc.nextDouble();
        shapes.add(new Rectangle(a, b));
    }
    
    private static void addCircle(){
        Double r;
        System.out.println("zadejte polomer kruhu");
        r = sc.nextDouble();
        shapes.add(Circle.getInstanceR(r));
    }
    
    private static void computeArea(){
        double allArea = 0;
        for(Shape shape : shapes){
            allArea += shape.computeArea();
        }
        System.out.println("Celkova plocha je: "+allArea);
    }
    
    private static void clearObjects(){
        shapes.clear();        
    }
    
    private static void  printObjects(){
        for(Shape shape : shapes){
            System.out.println(shape);
        }
    }
    
     private static void findWithMaxArea(){
         double max = -1;
         Shape maxShape = null;
         for (int i = 0; i < shapes.size(); i++) {
             if(shapes.get(i).computeArea() > max){
                 max = shapes.get(i).computeArea();
                 maxShape = shapes.get(i);
             }
         }
         System.out.println("Nejvetsi plochu ma "+maxShape+ ", jeho plocha je "+maxShape.computeArea());
         
     }
     
}
