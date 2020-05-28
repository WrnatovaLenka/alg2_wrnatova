package wrnatova_hurricane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lenka.wrnatova
 */
public class HuricaneApp implements HurricaneInterface{
   ArrayList<Hurricane> hurricanes = new ArrayList<>(); 
    
    
    @Override
    public void load()throws FileNotFoundException, IOException{
        File hurricaneFile = new File("hurricanedata.txt");
        Scanner load = new Scanner(hurricaneFile);
        while(load.hasNext()){
            int year = load.nextInt();
            String month = load.next();
            int pressure = load.nextInt();
            int speed = load.nextInt();
            String name = load.next();
            Hurricane h = new Hurricane(year, month, pressure, speed, name); 
            hurricanes.add(h);
        }   
    } 
    
    @Override
    public String hurricaneByName(String name){
       for (Hurricane hurricane: hurricanes) {
           if(hurricane.getName().equals(name)){
               return "Kategorie: Category " + hurricane.getHurricaneCategory() + ", rychlost: " + hurricane.getSpeedInKmH() + " km/h";
           }
       }
       return "Hurikan " + name + " nenalezen";
    }
    
    @Override
    public String hurricanesFromTo(int from, int to){
        StringBuilder sb = new StringBuilder("");
        for (Hurricane hurricane: hurricanes) {
            if(hurricane.getYear() >= from && hurricane.getYear() <= to){
                sb.append(hurricane);
                sb.append("\n");
            }
        }
        return sb.toString();
        
    }
    
    
    @Override
    public String hurricaneInfoBySpeed(){      
        Collections.sort(hurricanes, Comparator.comparing(Hurricane::getSpeedInKmH));
        StringBuilder sb = new StringBuilder();
        for (Hurricane hurricane: hurricanes) {
            sb.append(hurricane.toString());
            sb.append("\n");
        }
        return sb.toString();       
    }
    
    
}
