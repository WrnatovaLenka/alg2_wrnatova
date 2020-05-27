package cmd;

import java.io.File;

/**
 *
 * @author lenka.wrnatova
 */
public class Rename extends Command{
    
    @Override
    public String execute(File actualDir) {
        File f = new File(params[1]);
        File newF = new File(params[2]);
        f.renameTo(newF);
        return "nazev souboru byl zmenen";
    }
    
}
