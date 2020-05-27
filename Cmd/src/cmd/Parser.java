package cmd;

/**
 *
 * @author lenka.wrnatova
 */
public class Parser {
    
    public static Command parse(String line){
         
        String[] p = line.split(" +"); //p[0] dir; p[1] -e p[2] .java
        //TODO osetreni prazdneho prikazu
        char first = Character.toUpperCase(p[0].charAt(0));
        String name = Command.COMMAND_PACKAGE + "." + first + p[0].substring(1); //cmd.Dir
        try{
            Class c = Class.forName(name);
            Command command = (Command) c.newInstance();
            command.setParams(p);
            return command;
        } catch (Exception e){
            throw new RuntimeException("Nepodarilo se prokaz naparsovat");
        }
        
    }
    
}
